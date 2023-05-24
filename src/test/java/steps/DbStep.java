package steps;

public class DbStep {


    public static String getFnameQuery(){

        String query="select emp_firstname,emp_lastname " + "from hs_hr_employees " + "where employee_id=";
        return query;
    }
}
