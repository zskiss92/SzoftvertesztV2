package StepDefinitions.Inventory;

import StepDefinitions.HomePage;
import StepDefinitions.PageOperations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
public class Inventory {
    WebDriver driver = new FirefoxDriver();
    List<WebElement> myList;

    private HomePage homePage = new HomePage(driver);
    private PageOperations pageOperations = new PageOperations(driver);
    public String testValue = "";

    @Given("Open the inventory")
    public void open_the_inventory() {
        homePage.login();
    }
    @When("The value of product sort container is {string}")
    public void the_value_of_product_sort_container_is(String string) {
        Select select = new Select(pageOperations.findElementByClassName("product_sort_container"));
        select.selectByValue(string);
        testValue = string;
    }
    @Then("The products should be sorted")
    public void the_products_should_be_sorted() {
        if(testValue.equals("az")){
            myList = pageOperations.findElementsByClassNameList("inventory_item_name");
            Assert.assertEquals(myList.get(0).getText(), "Sauce Labs Backpack");
        }
        else if(testValue.equals("za")){
            myList = pageOperations.findElementsByClassNameList("inventory_item_name");
            Assert.assertEquals(myList.get(0).getText(), "Test.allTheThings() T-Shirt (Red)");
        }
        else if(testValue.equals("hilo")){
            myList = pageOperations.findElementsByClassNameList("inventory_item_name");
            Assert.assertEquals(myList.get(0).getText(), "Sauce Labs Fleece Jacket");
        }
        else if(testValue.equals("lohi")){
            myList = pageOperations.findElementsByClassNameList("inventory_item_name");
            Assert.assertEquals(myList.get(0).getText(), "Sauce Labs Onesie");
        }

        homePage.quitDriver();
    }
}
