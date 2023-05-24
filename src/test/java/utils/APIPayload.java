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


}
