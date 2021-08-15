package learn.mysql.demo02;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo02 {
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
//            deleteData(delete_sql,statement);
            List<Student> list = findAll(statement);
            System.out.println(list);
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
    private static List<Student> findAll(Statement statement){
        String sql = "select * from student";
        try {
            ResultSet query = statement.executeQuery(sql);
            List<Student> list = new ArrayList<>();
            while (query.next()){
                int id = query.getInt("id");
                String name = query.getString("name");
                int age = query.getInt("age");
                list.add(new Student(id,name,age));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
