package com.library.pages;

import com.library.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends com.library.pages.BasePage {

    @FindBy(id = "inputEmail")
    private WebElement emailInputBox;

    @FindBy(id = "inputPassword")
    private WebElement passwordInputBox;

    public void login(String role){

        String email = "";
        String password = "";

        if(role.equals("librarian")) {
            email = ConfigurationReader.getProperty("librarian.username");
            password = ConfigurationReader.getProperty("librarian.password");
        }else if(role.equals("student")){
            email = ConfigurationReader.getProperty("student.username");
            password = ConfigurationReader.getProperty("student.password");
        }

        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password, Keys.ENTER);
    }

}