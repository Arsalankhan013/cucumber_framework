package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.*;

import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

String id;
String firstname,lastname;
    @When("user clicks on PIM option")
    public void userClicksOnPIMOption() {
      click(dashpage.pimOption);
        
    }

    @And("user clicks on Add Employee button")
    public void userClicksOnAddEmployeeButton() {
        click(dashpage.addEmployeeOption);
    }

    @And("user enter firstname and lastname")
    public void userEnterFirstnameAndLastname() {
        sendText(addEmpPage.firstName,"aaaa");
        sendText(addEmpPage.lastName,"kkk");
    }

    @And("user clicks on save button")
    public void userClicksOnSaveButton() {
        click(addEmpPage.saveButton);
    }

    @Then("employee added successfully")
    public void employeeAddedSuccessfully() {

        System.out.println("Emp Added successfully");
    }

    @And("user enter {string} and {string}")
    public void userEnterAnd(String firstname, String lastname) {


        sendText(addEmpPage.firstName,firstname);
        sendText(addEmpPage.lastName,lastname);

    }

    @And("user enter {string} and {string} for adding multiple employees")
    public void userEnterAndForAddingMultipleEmployees(String firstname, String lastname) {

        sendText(addEmpPage.firstName,firstname);
        sendText(addEmpPage.lastName,lastname);
    }

    @When("user adds multiple employees and verify they are added successfully")
    public void userAddsMultipleEmployeesAndVerifyTheyAreAddedSuccessfully(DataTable dataTable) throws InterruptedException {

        List<Map<String,String>> employeeNames=dataTable.asMaps();

for(Map<String,String> emp:employeeNames){

   String firstNameValue= emp.get("firstName");
    String middleNameValue= emp.get("middleName");
    String lastNameValue= emp.get("lastName");

    sendText(addEmpPage.firstName,firstNameValue);
    sendText(addEmpPage.middleName,middleNameValue);
    sendText(addEmpPage.lastName,lastNameValue);

    click(addEmpPage.saveButton);
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }

click(dashpage.addEmployeeOption);
    Thread.sleep(200);

}


    }

    @When("user adds multiple employee from excel using {string} and verify it")
    public void userAddsMultipleEmployeeFromExcelUsingAndVerifyIt(String sheetName) throws InterruptedException {

        List<Map<String,String>> newEmployees=ExcelReader.excelListintoMap(Constants.ExcelData_FILEPATH,sheetName);

        for (Map<String, String> mapnewEMP : newEmployees) {

            sendText(addEmpPage.firstName, mapnewEMP.get("firstName"));
            sendText(addEmpPage.middleName, mapnewEMP.get("middleName"));
            sendText(addEmpPage.lastName, mapnewEMP.get("lastName"));
String empIDVALUE=addEmpPage.empIdLoc.getAttribute("value");
            sendText(addEmpPage.photograph, mapnewEMP.get("photograph"));

            if (!addEmpPage.checkBOX.isSelected()) {
                click(addEmpPage.checkBOX);
            }

            sendText(addEmpPage.username_employee, mapnewEMP.get("username"));
            sendText(addEmpPage.password_employee, mapnewEMP.get("password"));
            sendText(addEmpPage.confirmPassword_Employee, mapnewEMP.get("confirmPassword"));

            click(addEmpPage.saveButton);
            System.out.println("click on save btn");
            Thread.sleep(3000);
            click(dashpage.employeeListOption);
            Thread.sleep(2000);

            sendText(empListPage.empSearchIdFieldID,empIDVALUE );
            click(empListPage.searchButton);


            System.out.println(empIDVALUE.toString());


List<WebElement> rowData=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
for(int i=0; i< rowData.size(); i++){

    String rowText=rowData.get(i).getText();
    System.out.println(rowText);

    String expectedData=empIDVALUE+" "+mapnewEMP.get("firstName") + " " + mapnewEMP.get("middleName")+" "+mapnewEMP.get("lastName");

    System.out.println(expectedData);

    Assert.assertEquals(expectedData,rowText);
}
      }


    }

    @And("user captures employee id")
    public void userCapturesEmployeeId() {
id=addEmpPage.empIdLoc.getAttribute("value");
    }

    @And("added employee is displayed in database")
    public void addedEmployeeIsDisplayedInDatabase() {

       String Query= DbStep.getFnameQuery()+id;
List<Map<String,String>> dbData=dbUtils.getListOfMapsfromRset(Query);
        System.out.println(dbData);
String fnamedb=dbData.get(0).get("emp_firstname");
      String lastnamedb=  dbData.get(0).get("emp_lastname");

      Assert.assertEquals(firstname,fnamedb);

    }




}
