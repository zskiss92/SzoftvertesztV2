package StepDefinitions.Reset;

import StepDefinitions.HomePage;
import StepDefinitions.PageOperations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class ResetAppState {

    WebDriver driver = new FirefoxDriver();

    private HomePage homePage = new HomePage(driver);
    private PageOperations pageOperations = new PageOperations(driver);

    @Given("The user logs in to the site")
    public void the_user_logs_in_to_the_site() {
        homePage.login();
    }
    @Given("Add {string} and {string} to the cart")
    public void add_and_to_the_cart(String string, String string2) {
        pageOperations.findElementByIdAndClick(string);
        pageOperations.findElementByIdAndClick(string2);
    }
    @When("The reset app state button is clicked")
    public void the_reset_app_state_button_is_clicked() {
        pageOperations.findElementByIdAndClick("react-burger-menu-btn");
        pageOperations.findElementByIdAndClick("reset_sidebar_link");
    }
    @Then("Cart is empty")
    public void cart_is_empty() {
        Assert.assertTrue(!pageOperations.findElementByClassName("shopping_cart_link").toString().contains("shopping_cart_badge"));
        homePage.quitDriver();
    }
}
