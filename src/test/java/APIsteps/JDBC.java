package APIsteps;

import java.sql.*;

import static java.lang.Class.forName;

public class JDBC {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        String dbURL = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        final String username = "syntax_hrm";
        final String password = "syntaxhrm123";

        Connection connection = null;
        Statement statement = null;


        connection = DriverManager.getConnection(dbURL, username, password);

        statement = connection.createStatement();

        String sql = "select * " +
                "from hs_hr_employees ";

        ResultSet rs = statement.executeQuery(sql);

        ResultSetMetaData rsMetaData = rs.getMetaData();
int rowcount = 0;
        //System.out.println(rsMetaData.getColumnCount());
        System.out.println(rsMetaData.getColumnName(3));
        while (rs.next()) {
           String sss= rs.getString(3);
            System.out.println(sss);
            System.out.println(rsMetaData.getColumnName(3));



        }

    }
}












