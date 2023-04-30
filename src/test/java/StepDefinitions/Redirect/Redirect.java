package StepDefinitions.Redirect;

import StepDefinitions.HomePage;
import StepDefinitions.PageOperations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Redirect {

    WebDriver driver = new FirefoxDriver();

    private HomePage homePage = new HomePage(driver);
    private PageOperations pageOperations = new PageOperations(driver);

    @Given("The user sign in to the site")
    public void the_user_sign_in_to_the_site() {
        homePage.login();
    }
    @When("The about button clicked")
    public void the_about_button_clicked() {
        pageOperations.findElementByIdAndClick("react-burger-menu-btn");
        pageOperations.findElementByIdAndClick("about_sidebar_link");
    }
    @Then("Redirection should be success")
    public void redirection_should_be_success() {
        Assert.assertEquals(pageOperations.getCurrentUrl(), "https://saucelabs.com/");
        homePage.quitDriver();
    }
}
