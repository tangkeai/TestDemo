package test.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main4 {
    public static void main(String[] args) {
        //query("三'");//使用PreparedStatement可以防止sql注入
        query("三");
    }
    public static void query(String query)  {
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 创建数据库连接
            DataSource dataSource = new MysqlDataSource();
            ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://localhost:3306/testdemo?user=root&password=1234&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
            connection = dataSource.getConnection();
            //创建操作命令对象(带占位符的sql在数据库预编译，可以提高效率，占位符的方式，可以防止sql注入（用 / 转义符放置注入）)
            String sql = "select * from test where name like ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+query+"%");
            //执行sql语句
            resultSet = statement.executeQuery();

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
