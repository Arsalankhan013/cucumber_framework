package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class addEmployeePage extends CommonMethods {

    @FindBy(id="firstName")
    public WebElement firstName;

    @FindBy(id="middleName")
    public WebElement middleName;

    @FindBy(id="lastName")
    public WebElement lastName;

    @FindBy(id="btnSave")
    public WebElement saveButton;
    @FindBy(id="photofile")
    public WebElement photograph;

    @FindBy(id="chkLogin")
    public WebElement checkBOX;

    @FindBy(id="user_name")
    public WebElement username_employee;
    @FindBy(id="user_password")
    public WebElement password_employee;

    @FindBy(id="re_password")
    public WebElement confirmPassword_Employee;


    @FindBy(id="employeeId")
    public WebElement empIdLoc;


    public addEmployeePage(){
        PageFactory.initElements(driver, this);
    }

}
