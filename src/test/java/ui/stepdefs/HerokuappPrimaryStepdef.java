package ui.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.commonMethods.CommonMethods;
import ui.objects.HerokuappPrimaryObject;

import java.util.List;

public class HerokuappPrimaryStepdef {

    private HerokuappPrimaryObject herokuappPrimaryObject = new HerokuappPrimaryObject();

    @Given("I'm in the homepage")
    public void imInTheHomepage(){
        CommonMethods.putStepNameToScenarioContext("I'm in the homepage");
        herokuappPrimaryObject.loadHomePage();
    }

    @And("The page heading is {string}")
    public void thePageHeadingIs(String heading){
        CommonMethods.putStepNameToScenarioContext("The page heading is "+heading);
        herokuappPrimaryObject.validateHeading(heading);
    }

    @When("I click on {string} option")
    public void iClickOnOption(String link){
        CommonMethods.putStepNameToScenarioContext("I click on "+link+" option");
        herokuappPrimaryObject.clickOnLink(link);
    }

    @And("The page sub heading is {string}")
    public void thePageSubheadingIs(String subHeading){
        CommonMethods.putStepNameToScenarioContext("The page sub heading is "+subHeading);
        herokuappPrimaryObject.validateSubHeading(subHeading);
    }

    @Then("I should be able to check the checkboxes")
    public void iShouldBeAbleToCheckTheCheckboxes(){
        CommonMethods.putStepNameToScenarioContext("I should be able to check the checkboxes");
        herokuappPrimaryObject.iShouldBeAbleToCheckTheCheckboxes();
    }

    @Then("The dropdown should contain below options")
    public void theDropdownShouldContainBelowOptions(List<String> options){
        CommonMethods.putStepNameToScenarioContext("The dropdown should contain below options "+options.toString());
        herokuappPrimaryObject.theDropdownShouldContainBelowOptions(options);
    }

    @And("I should be able to select the available options")
    public void iShouldBeAbleToSelectTheOptions(List<String> options){
        herokuappPrimaryObject.iShouldBeAbleToSelectTheOptions(options);
    }
}
