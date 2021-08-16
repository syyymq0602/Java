package mysql.demo01;

import java.sql.*;

public class JDBCdemo01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");

            String create_table_sql = "create table student(id int primary key auto_increment," +
                    "name varchar(50)," +
                    "age int)";

            String insert_sql = "insert into student value(null,'Anna',20)";
            String query_sql = "select * from student";
            String update_sql = "update student set age = 21 where id = 2";
            String delete_sql = "delete from student where id = 2";
            statement = conn.createStatement();
//        createTable(create_table_sql,conn);
//        insertData(insert_sql,statement);
//        queryData(query_sql,statement);
//            updateData(update_sql,statement);
            deleteData(delete_sql,statement);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void createTable(String sql, Connection connection) {
        try {
            Statement statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println("成功创建" + count + "个表.....");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertData(String sql, Statement statement) {
        try {
            int count = statement.executeUpdate(sql);
            System.out.println("成功插入" + count + "条数据.....");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void queryData(String sql, Statement statement){
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getString("name") + resultSet.getObject("age"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateData(String sql, Statement statement){
        try {
            int count = statement.executeUpdate(sql);
            System.out.println("成功更新" + count + "条数据.....");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteData(String sql,Statement statement){
        try {
            int count = statement.executeUpdate(sql);
            System.out.println("成功删除" + count + "条数据.....");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
