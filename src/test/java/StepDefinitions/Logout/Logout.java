package StepDefinitions.Logout;

import StepDefinitions.HomePage;
import StepDefinitions.PageOperations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Logout {

    WebDriver driver = new FirefoxDriver();

    private HomePage homePage = new HomePage(driver);
    private PageOperations pageOperations = new PageOperations(driver);

    @Given("Open the homepage")
    public void open_the_homepage() {
        homePage.loginOpen();
    }
    @Given("Login to the site")
    public void login_to_the_site() {
        homePage.loginUserName("standard_user");
        homePage.loginPassword("secret_sauce");
        homePage.loginClick();
    }
    @When("The logout button clicked")
    public void the_logout_button_clicked() {
        pageOperations.findElementByIdAndClick("react-burger-menu-btn");
        pageOperations.findElementByIdAndClick("logout_sidebar_link");
    }
    @Then("Logout should be success")
    public void logout_should_be_success() {
        Assert.assertEquals(pageOperations.getCurrentUrl(), "https://www.saucedemo.com/");
        homePage.quitDriver();
    }
}
