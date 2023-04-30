package StepDefinitions.Purchase;

import StepDefinitions.HomePage;
import StepDefinitions.PageOperations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Purchase {
    WebDriver driver = new FirefoxDriver();

    private HomePage homePage = new HomePage(driver);
    private PageOperations pageOperations = new PageOperations(driver);
    @Given("Sign in to the site")
    public void sign_in_to_the_site() {
        homePage.login();
    }
    @Given("Open the details page of the item with {string} button")
    public void open_the_details_page_of_the_item_with_button(String string) {
        pageOperations.findElementByIdAndClick(string);
    }
    @Given("Add the item to cart")
    public void add_the_item_to_cart() {
        pageOperations.findElementByTagNameAndClick("button");
    }
    @Given("Open the cart page")
    public void open_the_cart_page() {
        pageOperations.openUrl("https://www.saucedemo.com/cart.html");
    }
    @Given("Open the checkout page")
    public void open_the_checkout_page() {
        pageOperations.findElementByIdAndClick("checkout");
    }
    @Given("Fill the necessary fields with {string}, {string} and {string}")
    public void fill_the_necessary_fields_with_and(String string, String string2, String string3) {
        pageOperations.findElementById("first-name").sendKeys(string);
        pageOperations.findElementById("last-name").sendKeys(string2);
        pageOperations.findElementById("postal-code").sendKeys(string3);
        pageOperations.findElementByIdAndClick("continue");
    }
    @When("The finish button clicked")
    public void the_finish_button_clicked() {
        pageOperations.findElementByIdAndClick("finish");
    }
    @Then("Purchase should be success")
    public void purchase_should_be_success() {
        Assert.assertTrue(pageOperations.findElementByClassName("complete-header").isDisplayed());
        homePage.quitDriver();
    }
}