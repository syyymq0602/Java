package mysql.demo05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo2 {
    public static void main(String[] args) {
        /*
         * 添加操作给db1
         */
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DruidUtils.getConnection();
            String sql = "insert into student values(null,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"Nike");
            preparedStatement.setInt(2,21);

            int count = preparedStatement.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.close(preparedStatement,connection);
        }
    }
}
