package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class YourStorePage {
    private WebDriver driver;

    private By accountSectionsLinks = By.xpath("//h2[text()='My Account']/../ul//a");


    public YourStorePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getYourStorePageTitle(){
        return driver.getTitle();
    }

    public int getCusotmerServiceSectionCount() {
        return driver.findElements(accountSectionsLinks).size();
    }

    public List<String> getAccountSectionsLinks() {
        List<String> myList = new ArrayList<>();
        List<WebElement> customerServiceSectionList = driver.findElements(accountSectionsLinks);
        for (WebElement each : customerServiceSectionList) {
            String text = each.getText();
            System.out.println("text-->>"+ text);
            myList.add(text);
        }
        return myList;
    }
}
