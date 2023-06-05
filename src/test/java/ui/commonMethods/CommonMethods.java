package ui.commonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.ProjectProperties;
import utilities.ScenarioContext;
import utilities.exceptions.PropertyNotFound;

import java.time.Duration;

public class CommonMethods {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor javascriptExecutor;

    public CommonMethods(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(getProperties("timeout").toString())));
        javascriptExecutor = (JavascriptExecutor) driver;
    }
    public static void putStepNameToScenarioContext(String stepName){
        ScenarioContext.put("stepName", stepName);
    }

    public String getProperties(String key){
        String value;
        try{
            ProjectProperties projectProperties = new ProjectProperties();
            value = projectProperties.get(key);
        } catch (PropertyNotFound e) {
            throw new RuntimeException(e);
        }
        return value;
    }

    public void loadHomePage() {
        String url = getProperties("url");
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void validateText(String text, By by){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        highlightElement(element);
        Assert.assertTrue(text.equalsIgnoreCase(element.getText().trim()), "Expected text: "+text+" but found: "+element.getText().trim());
    }

    public void highlightElement(By by){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        javascriptExecutor.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public void highlightElement(WebElement element){
        javascriptExecutor.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public void clickOnHomepageLink(String link){
        String xpath = "//a[normalize-space()='"+link+"']";
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        element.click();
    }

    public void validatePageSubHeading(String subHeading) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        highlightElement(element);
        Assert.assertTrue(subHeading.equalsIgnoreCase(element.getText().trim()), "Expected subheading: "+subHeading+" but found: "+element.getText().trim());
    }
}
