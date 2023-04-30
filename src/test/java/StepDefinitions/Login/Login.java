package StepDefinitions.Login;

import StepDefinitions.HomePage;
import StepDefinitions.PageOperations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {

    WebDriver driver = new FirefoxDriver();

    private HomePage homePage = new HomePage(driver);
    private PageOperations pageOperations = new PageOperations(driver);
    @Given("The user name is standard_user")
    public void the_user_name_is_standard_user() {
        homePage.loginOpen();
        homePage.loginUserName("standard_user");
    }
    @Given("The password is secret_sauce")
    public void the_password_is_secret_sauce() {
        homePage.loginPassword("secret_sauce");
    }
    @When("The login button clicked")
    public void the_login_button_clicked() {
        homePage.loginClick();
    }
    @Then("Login should be success")
    public void login_should_be_success() {
        Assert.assertTrue(pageOperations.getCurrentUrl().contains("inventory"));
        homePage.quitDriver();
    }
}