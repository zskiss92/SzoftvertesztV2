package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageOperations {

    WebDriver driver;

    public PageOperations() {
        // ignore
    }

    public PageOperations(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String url){
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public WebElement findElementById(String element){
        return driver.findElement(By.id(element));
    }

    public void findElementByIdAndClick(String element){
        driver.findElement(By.id(element)).click();
    }

    public WebElement findElementByClassName(String element){
        return driver.findElement(By.className(element));
    }

    public List<WebElement> findElementsByClassNameList(String element){
        return driver.findElements(By.className(element));
    }

    public void findElementByClassNameAndClick(String element){
        driver.findElement(By.className(element)).click();
    }

    public void findElementByTagNameAndClick(String element) {
        driver.findElement(By.tagName(element)).click();
    }
}
