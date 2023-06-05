package ui.commonMethods;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utilities.ProjectProperties;
import utilities.exceptions.PropertyNotFound;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driverStore = new ThreadLocal<>();
    private ProjectProperties properties;
    private WebDriver driver;

    @Before
    public void setUp(){
        String browser;
        if(driverStore.get() == null){
            try {
                properties = new ProjectProperties();
                browser = properties.get("browser");
                switch (browser){
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    default:
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                }
            }
            catch (PropertyNotFound propertyNotFound){
                propertyNotFound.printStackTrace();
            }
        }
        driverStore.set(driver);
    }

    public static WebDriver getDriver(){
        return driverStore.get();
    }

    @AfterStep
    public void afterStep(Scenario scenario){
        ScreenshotUtils screenshotUtils = new ScreenshotUtils();
        screenshotUtils.attachScreenshotToReport(scenario, driver);
    }

    @After
    public void tearDown(){
        driverStore.get().quit();
    }
}
