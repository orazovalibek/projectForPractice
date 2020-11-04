package com.library.pages;


import com.library.utilities.Thread;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(com.library.utilities.Driver.getDriver(), this);
    }

    public void navigateAndClickTo(String tab){

        Thread.wait(2);

        String tabXpath = "//*[contains(text(),'"+tab+"') and @class='title']";

        WebDriverWait wait = new WebDriverWait(com.library.utilities.Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tabXpath))).click();

    }



}