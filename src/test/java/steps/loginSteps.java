package steps;

import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;


public class loginSteps extends CommonMethods {
public static WebDriver driver;

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
      openBrowserAndLaunchApplication();
    }


    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {

sendText(loginPage.usernameTextField, ConfigReader.getPropertyValue("username"));
        sendText(loginPage.passwordTextField,ConfigReader.getPropertyValue("password"));

    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.loginButton.click();


    }
    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        System.out.println("Test Passed successfully");
    }
    @When("user enters ess username and password")
    public void user_enters_ess_username_and_password() {
       sendText(loginPage.usernameTextField,"admin");
        sendText(loginPage.passwordTextField,"Hum@nhrm123");
    }
    @Then("ess user is successfully logged in")
    public void ess_user_is_successfully_logged_in() {
        System.out.println("ESS user is successfully logged in");
    }

    @When("user enter invalid username and password")
    public void user_enter_invalid_username_and_password() {
        sendText(loginPage.usernameTextField, "admi");


        sendText(loginPage.passwordTextField, "Hum");
    }
    @Then("user is able to see error message")
    public void user_is_able_to_see_error_message() {
        String actualerrorMessage=loginPage.errorMessage.getText();
        Assert.assertEquals("Invalid credentials",actualerrorMessage);
        System.out.println("Test failed" + actualerrorMessage);
    }
    @When("user enters different {string} and {string} and verify the {string}")
    public void user_enters_different_and_and_verify_the(String username, String password, String error) {
        // Write code here that turns the phrase above into concrete actions
sendText(loginPage.usernameTextField,username );
sendText(loginPage.passwordTextField,password);
click(loginPage.loginButton);
String actualerrorMessage=loginPage.errorMessage.getText();
        Assert.assertEquals(error,actualerrorMessage);
    }















}
