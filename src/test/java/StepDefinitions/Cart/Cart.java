package StepDefinitions.Cart;

import StepDefinitions.HomePage;
import StepDefinitions.PageOperations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cart {

    WebDriver driver = new FirefoxDriver();

    private HomePage homePage = new HomePage(driver);
    private PageOperations pageOperations = new PageOperations(driver);
    @Given("Open the site and login")
    public void open_the_site_and_login() {
        homePage.login();
    }
    @When("Add product to cart with {string} button")
    public void add_product_to_cart_with_button(String string) {
        pageOperations.findElementByIdAndClick(string);
    }
    @When("Open the cart")
    public void open_the_cart() {
        pageOperations.openUrl("https://www.saucedemo.com/cart.html");
    }
    @Then("Remove the product from the cart with {string} button")
    public void remove_the_product_from_the_cart_with_button(String string) {
        pageOperations.findElementByIdAndClick(string);
        homePage.quitDriver();
    }
}
