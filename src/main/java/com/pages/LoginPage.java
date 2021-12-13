package com.pages;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By emailid = By.xpath("//input[@id='input-email']");
    private By password = By.xpath("//input[@id='input-password']");
    private By loginButton = By.xpath("//input[@value='Login']");
    private By forgotPwd = By.xpath("//div[@class='form-group']//a[normalize-space()='Forgotten Password_XYZ']");
    private By myAccount = By.xpath("//span[normalize-space()='My Account']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean isForgotPassordLinkExists() {
        return driver.findElement(forgotPwd).isDisplayed();
    }

    public void enterUserName(String userName) {
        driver.findElement(emailid).sendKeys(userName);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isDisplayedLoginPage() {
        return driver.findElement(myAccount).isDisplayed();
    }

    public YourStorePage doLogin(String uName, String pWord) {
        driver.findElement(emailid).sendKeys(uName);
        driver.findElement(password).sendKeys(pWord);
        driver.findElement(loginButton).click();
        return new YourStorePage(driver);

    }


}
