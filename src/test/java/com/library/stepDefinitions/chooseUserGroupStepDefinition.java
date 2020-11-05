package com.library.stepDefinitions;

import com.library.pages.UserManagementPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class chooseUserGroupStepDefinition {

    UserManagementPage userManagementPage = new UserManagementPage();

    @When("user clicks {string} tab")
    public void user_clicks_users_tab(String string) {
        userManagementPage.navigateAndClickTo(string);
    }


    @When("user choose {string} from Users Group dropdown")
    public void user_choose_from_dropdown(String users) {
        userManagementPage.chooseFromUserGroupsDropdown(users);
    }


    @Then("user should see only {string} in the list")
    public void user_should_see_only_in_the_list(String string) {
       switch (string.toLowerCase()){
           case "students":
               userManagementPage.sortUserGroups("ascending");
               String studentUserGroup = userManagementPage.getFirstUserGroupName();
               Assert.assertEquals(string, studentUserGroup);
               break;
           case "librarian":
               userManagementPage.sortUserGroups("descending");
               String librarianUserGroup = userManagementPage.getFirstUserGroupName();
               Assert.assertEquals(string, librarianUserGroup);
       }

    }


}
