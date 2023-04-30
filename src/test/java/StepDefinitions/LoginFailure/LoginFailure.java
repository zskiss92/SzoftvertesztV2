package StepDefinitions.LoginFailure;

import StepDefinitions.HomePage;
import StepDefinitions.PageOperations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginFailure {
    WebDriver driver = new FirefoxDriver();

    private HomePage homePage = new HomePage(driver);
    private PageOperations pageOperations = new PageOperations(driver);
    @Given("The user name is {string}")
    public void the_user_name_is(String string) {
        homePage.loginOpen();
        homePage.loginUserName(string);
    }
    @Given("The password is {string}")
    public void the_password_is(String string) {
        homePage.loginPassword(string);
    }
    @When("The green login button clicked")
    public void the_green_login_button_clicked() {
        homePage.loginClick();
    }
    @Then("Login should be not success")
    public void login_should_be_not_success() {
        Assert.assertTrue(pageOperations.findElementByClassName("error-message-container").isDisplayed());
        homePage.quitDriver();
    }
}
