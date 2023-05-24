package steps;

import pages.EmployeeListPage;
import pages.LoginPage;
import pages.addEmployeePage;
import pages.dashboardPage;

public class Pageinitializer {
    public static LoginPage loginPage;
    public static addEmployeePage addEmpPage;
    public static dashboardPage dashpage;
    public static EmployeeListPage empListPage;

    public static void initializePageObjects() {

        loginPage = new LoginPage();
addEmpPage=new addEmployeePage();
dashpage=new dashboardPage();
empListPage=new EmployeeListPage();

    }
}
