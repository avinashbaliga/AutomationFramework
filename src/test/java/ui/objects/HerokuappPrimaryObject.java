package ui.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.commonMethods.CommonMethods;
import ui.commonMethods.DriverFactory;
import utilities.ProjectProperties;

import java.time.Duration;

public class HerokuappPrimaryObject {

    private WebDriver driver;
    private ProjectProperties projectProperties;
    private WebDriverWait wait;
    private CommonMethods commonMethods;

    /*************************************************************************************
     *************************** Mention all the Bys inside this *************************/

    private By pageHeading = By.xpath("//h1[@class='heading']");

    /***************************************************************************************/

    public HerokuappPrimaryObject() {
        driver = DriverFactory.getDriver();
        projectProperties = new ProjectProperties();
        commonMethods = new CommonMethods(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(commonMethods.getProperties("timeout").toString())));
    }

    public void loadHomePage() {
        commonMethods.loadHomePage();
    }

    public void validateHeading(String text){
        commonMethods.validateText(text, pageHeading);
    }

    public void clickOnLink(String link) {
        commonMethods.clickOnHomepageLink(link);
    }

    public void validateSubHeading(String subHeading) {
        commonMethods.validatePageSubHeading(subHeading);
    }
}
