package com.library.stepDefinitions;

import com.library.pages.UserManagementPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class chooseStatusStepDefinition {

    UserManagementPage userManagementPage = new UserManagementPage();


    @When("user choose {string} from Status dropdown")
    public void user_choose_from_status_dropdown(String string) {
            userManagementPage.chooseFromStatusDropdown(string);
    }



    @Then("user should see only {string} records in the list")
    public void user_should_see_only_records_in_the_list(String string) {
        userManagementPage.sortStatus(string.toLowerCase());

    }

}
