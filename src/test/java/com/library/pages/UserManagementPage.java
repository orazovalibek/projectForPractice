package com.library.pages;

import com.library.utilities.Driver;
import com.library.utilities.Thread;
import org.junit.Assert;
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

    @FindBy (xpath = "//select[@id='user_status']")
    private  WebElement statusDropdown;



    public void chooseFromUserGroupsDropdown(String users){

        Select select = new Select(userGroupDropdown);
        select.selectByVisibleText(users);

    }

    public void chooseFromStatusDropdown(String status){

        Select select = new Select(statusDropdown);
        select.selectByVisibleText(status);

    }

    @FindBy (xpath = "//th[@data-name='status']")
    private WebElement sortStatusBtn;


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
    public void sortStatus(String string) {
        if (string.equals("active")) {
            Thread.wait(2);
            sortStatusBtn.click();
            Thread.wait(2);
            Assert.assertEquals(getFirstStatus(),string);
        } else if (string.equals("inactive")) {
            Thread.wait(2);
            sortStatusBtn.click();
            Thread.wait(2);
            sortStatusBtn.click();
            Thread.wait(2);
            Assert.assertEquals(getFirstStatus(),string);
        }
    }
    public String getFirstUserGroupName(){
        return Driver.getDriver().findElement(By.xpath("//tr[1]/td[5]")).getText();
    }

    public String getFirstStatus(){
        return Driver.getDriver().findElement(By.xpath("//tbody/tr[1]/td[6]")).getText().toLowerCase();
    }

}
