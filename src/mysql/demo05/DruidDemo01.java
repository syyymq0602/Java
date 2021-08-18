package mysql.demo05;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo01 {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        InputStream resource = DruidDemo01.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(resource);
        DataSource source = DruidDataSourceFactory.createDataSource(prop);

        Connection connection = source.getConnection();

        System.out.println(connection);
    }
}
