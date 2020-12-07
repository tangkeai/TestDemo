package test.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class Main3 {
    public static void main(String[] args) {
        //sql注入
        //query("三'");
        query("三");
    }
    public static void query(String query)  {
        ResultSet resultSet = null;
        Connection connection = null;
        Statement statement = null;
        try {
            // 创建数据库连接
            DataSource dataSource = new MysqlDataSource();
            ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://localhost:3306/testdemo?user=root&password=1234&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
            connection = dataSource.getConnection();
            //创建操作命令对象
            statement = connection.createStatement();
            //执行sql语句
            resultSet = statement.executeQuery("select * from test where name like '%"+query+"%'");
            //处理结果集ResultSet（类似于List<Map<String,字段类型>>）
            while (resultSet.next()) {//遍历每一行数据
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int chinese = resultSet.getInt(3);
                int math = resultSet.getInt(4);
                int english = resultSet.getInt(5);
                System.out.println(String.format("Student: id=%d, name=%s, chinese=%d, math=%d, english=%d", id, name, chinese, math, english));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //释放资源（关闭结果集，命令，连接）
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
