package ui.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ui.commonMethods.CommonMethods;
import ui.commonMethods.DriverFactory;
import utilities.ProjectProperties;

import java.time.Duration;
import java.util.List;

public class HerokuappPrimaryObject {

    private WebDriver driver;
    private ProjectProperties projectProperties;
    private WebDriverWait wait;
    private CommonMethods commonMethods;

    /*************************************************************************************
     *************************** Mention all the Bys inside this *************************/

    private By pageHeading = By.xpath("//h1[@class='heading']");
    private By checkBoxes = By.xpath("//form[@id='checkboxes']/input");
    private By dropDown = By.id("dropdown");

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

    public void iShouldBeAbleToCheckTheCheckboxes() {
        List<WebElement> checkBoxElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(checkBoxes));

        if(checkBoxElements.size() > 0){
            checkBoxElements.forEach((element)->{
                if(!element.isSelected()){
                    element.click();
                }
            });
        }

        checkBoxElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(checkBoxes));

        checkBoxElements.forEach((element) -> {
            Assert.assertTrue(element.isSelected(), "Checkbox is not selected");
        });
    }

    public void theDropdownShouldContainBelowOptions(List<String> options) {
        WebElement dropDownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dropDown));
        Select select = new Select(dropDownElement);
        List<WebElement> selectOptions = select.getOptions();
        Assert.assertTrue(selectOptions.size() > 0, "No dropdown options found");
        boolean optionFound;

        for(String option: options){
            optionFound = false;
            for(WebElement selectOption: selectOptions){
                if(selectOption.getText().trim().equalsIgnoreCase(option)){
                    optionFound = true;
                    break;
                }
            }
            if(!optionFound){
                Assert.fail(option+" not found in dropdown");
            }
        }

        dropDownElement.click();
    }

    public void iShouldBeAbleToSelectTheOptions(List<String> options) {

    }
}
