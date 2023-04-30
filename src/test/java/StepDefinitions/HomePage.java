package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {
    WebDriver driver;

    public HomePage() {
        // ignore
    }

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void login(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
    }

    public void loginOpen() {
        driver.get("https://www.saucedemo.com/");
    }

    public void loginUserName(String username) {
        driver.findElement(By.name("user-name")).sendKeys(username);
    }

    public void loginPassword(String password){
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void loginClick() {
        driver.findElement(By.name("login-button")).click();
    }

    public void quitDriver(){
        driver.quit();
    }
}
