package utils;

import org.json.JSONObject;

public class APIPayload {

    public static String createEmployeePayloadAPI(String firstname,String lastname,String middlename,String gender,String birthday,String empStatus,String jobTitle)
    {
        JSONObject obj=new JSONObject();
        obj.put("emp_firstname",firstname);
        obj.put("emp_lastname",lastname);
        obj.put("emp_middlename",middlename);
        obj.put("emp_gender",gender);
        obj.put("emp_birthday",birthday);
        obj.put("emp_status",empStatus);
        obj.put("emp_job_title",jobTitle);

return obj.toString();

    }

    public static String createEmployeeJsonBody(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "sara");
        obj.put("emp_lastname", "bou");
        obj.put("emp_middle_name", "ms");
        obj.put("emp_gender", "F");
        obj.put("emp_birthday", "2011-01-12");
        obj.put("emp_status", "confirmed");
        obj.put("emp_job_title","QA Engineer");
        return obj.toString();
    }


}
