package test.jdbc;
import java.sql.*;

public class Main2 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdemo?user=root&password=1234&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
            String sql = "select id,name,math from test";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int math = resultSet.getInt(3);
                System.out.println(String.format("Student: id=%d, name=%s, math=%d",id,name,math));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
