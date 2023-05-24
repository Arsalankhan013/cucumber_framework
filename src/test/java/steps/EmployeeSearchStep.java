package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.List;

public class EmployeeSearchStep extends CommonMethods {

    @When("user clicks on employee list option")
    public void user_clicks_on_employee_list_option() {
      click(dashpage.employeeListOption);
    }


    @When("user enters a valid employee id")
    public void user_enters_a_valid_employee_id() {
    sendText(empListPage.empSearchIdFieldID, "53481A");
    }

    @When("employee clicks on search button")
    public void employee_clicks_on_search_button() {
       click(empListPage.searchButton);
    }

    @Then("user is able to see the employee")
    public void user_is_able_to_see_the_employee() {
        String empinformation = null;
List<WebElement> empdatarow=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
for(WebElement empinfo:empdatarow){
    System.out.println(empinfo.getText());
 empinformation=empinfo.getText();
}
       Assert.assertEquals(empinformation,"53481A Selab21 ms Ahmadzai Engineer confirmed");
    }

    @When("user enters a employee name")
    public void user_enters_a_employee_name() {
        String empinformation = null;
        sendText(empListPage.empSearchNameField, "Selab21");
        click(empListPage.searchButton);
        List<WebElement> empdatarow=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
        for(WebElement empinfo:empdatarow){
            System.out.println(empinfo.getText());
            empinformation=empinfo.getText();
        }
        Assert.assertEquals(empinformation,"53481A Selab21 ms Ahmadzai Engineer confirmed");
    }
    }

