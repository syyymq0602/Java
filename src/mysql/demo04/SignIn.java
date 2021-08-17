package mysql.demo04;

import mysql.demo03.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class SignIn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String user = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();

        boolean login = login(user, password);

        if(login){
            System.out.println("登陆成功！");
        }else {
            System.out.println("用户名或密码错误！");
        }
    }
    private static boolean login(String user, String password){
        if (user==null || password==null){
            return false;
        }
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 建立连接
            connection = JDBCUtils.getConnection();
            // 定义查询语句
            String sql = "select * from user where username = '"+ user + "' and password = '"+ password+"'";
            // 执行sql语句
            statement = connection.createStatement();
            // 执行查询
            resultSet = statement.executeQuery(sql);
            // 判断是否有结果
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(statement,connection,resultSet);
        }
        return false;
    }

    /**
     * 使用 PreparedStatement
     * @param user
     * @param password
     * @return
     */
    private static boolean login2(String user, String password){
        if (user==null || password==null){
            return false;
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 建立连接
            connection = JDBCUtils.getConnection();
            // 定义查询语句
            String sql = "select * from user where username = ? and password = ?";
            // 执行sql语句
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,password);
            // 执行查询
            resultSet = preparedStatement.executeQuery();
            // 判断是否有结果
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(preparedStatement,connection,resultSet);
        }
        return false;
    }
}
