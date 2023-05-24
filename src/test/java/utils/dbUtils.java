package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class dbUtils {

    private static ResultSetMetaData resultSetMetaData;
    private static ResultSet resultSet;

    public static ResultSet getResultSet(String sqlQuery) {

        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection(
                    ConfigReader.getPropertyValue("dbURL"),
                    ConfigReader.getPropertyValue("dbUsername"),
                    ConfigReader.getPropertyValue("dbPassword"));
            statement = conn.createStatement();

            resultSet = statement.executeQuery(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static ResultSetMetaData getRsetMetdaData(String query)  {
       resultSet= getResultSet(query);
       resultSetMetaData=null;

        try {
           resultSetMetaData =resultSet.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultSetMetaData;
    }

public static List<Map<String,String>> getListOfMapsfromRset(String query)  {
        resultSetMetaData=getRsetMetdaData(query);
        List<Map<String,String>> listfromRset=new ArrayList<>();
        Map<String,String>mapData;
            try {
                while (resultSet.next()){
                    mapData=new LinkedHashMap<>();
                    for (int i=1; i<=resultSetMetaData.getColumnCount();i++){
                      String columnNamekey=resultSetMetaData.getColumnName(i) ;
                        String value =resultSet.getString(columnNamekey);

mapData.put(columnNamekey,value);
                    }
listfromRset.add(mapData);
            }
        } catch (SQLException e) {
                e.printStackTrace();
            }
return listfromRset;
}
}
