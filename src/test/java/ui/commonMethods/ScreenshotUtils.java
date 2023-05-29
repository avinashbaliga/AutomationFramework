package ui.commonMethods;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.ScenarioContext;

public class ScreenshotUtils {

    public void attachScreenshotToReport(Scenario scenario, WebDriver driver){
        byte[] image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        String imageName = ScenarioContext.get("stepName").toString();
        scenario.attach(image, "image/png", imageName);
    }
}
