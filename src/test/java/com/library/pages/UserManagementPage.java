package com.library.pages;

import com.library.utilities.Driver;
import com.library.utilities.Thread;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserManagementPage extends BasePage {

    @FindBy(id = "user_groups")
    private WebElement userGroupDropdown;

    public void chooseFromUserGroupsDropdown(String users){

        Select select = new Select(userGroupDropdown);
        select.selectByVisibleText(users);

    }

    @FindBy(xpath = "//*[@id=\"tbl_users\"]/thead/tr/th[5]")
    private WebElement groupSortBtn;

    public void sortUserGroups(String expectedOrder){

        for (int i = 0; i < 4; i++) {
            Thread.wait(2);
            groupSortBtn.click();
            Thread.wait(2);
            String actualOrder = groupSortBtn.getAttribute("aria-sort");
            if(expectedOrder.equalsIgnoreCase(actualOrder)){
                break;
            }
        }
    }

    public String getFirstUserGroupName(){
        return Driver.getDriver().findElement(By.xpath("//tr[1]/td[5]")).getText();
    }

}
