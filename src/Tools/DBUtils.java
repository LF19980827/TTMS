package Tools;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 * @author LFuser
 * @create 2019-05-18-21:36
 * 需要的jar包 ：
 * 1.mysql-connector-java-8.0.16.jar
 * 2.commons-pool2-2.6.1.jar
 * 3.commons-dbcp2-2.6.0.jar
 * 4.commons-dbutils-1.7.jar
 */
public class DBUtils<T> implements DAO<T> {

    private QueryRunner queryRunner = null;
    private Class<T> type;

    public DBUtils() {
        queryRunner = new QueryRunner();
        type = ReflectionUtils.getSuperGenericType(getClass());
    }

    //数据库连接池只初始化一次
    private static DataSource dataSource = null;

    /**
     * 1.加载 dbcp 的 properties 配置文件
     * 2.调用 BasicDataSourceFactory 的 createDataSource 方法 创建 DataSource实例
     */
//    static {
//        Properties properties = new Properties();
//        InputStream inputStream =
//                DBUtils.class.getClassLoader().getResourceAsStream("dbcp.properties");
//        try {
//            properties.load(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            dataSource = BasicDataSourceFactory.createDataSource(properties);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 从 DataSource实例中获取数据库连接
     *
     * @return 返回一个数据库连接
     */
    public static Connection getConnection() {
//        Connection connection = null;
//        try {
//            connection = dataSource.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
        //0.读取 jdbc.properties
        /**
         * 1).属性文件对应 Java 中的 Properties 类
         * 2).可以使用类加载器加载 bin 目录(类路径下)的文件
         */
        Properties properties = new Properties();
        InputStream inStream =
                DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //1.准备获取连接的4个字符串：driverClass,jdbcUrl,user,password
        String driverClass = properties.getProperty("driver");
        String jdbcUrl = properties.getProperty("jdbcUrl");
        String user = properties.getProperty("user") ;
        String password = properties.getProperty("password");

        //2.加载驱动：Class.forName(driverClass)
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //3.调用 DriverManager 的 getConnection(jdbcUrl,user,password) 方法获取数据库连接
        Connection connection =
                null;
        try {
            connection = DriverManager.getConnection(jdbcUrl,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }

    /**
     * 将连接放回连接池
     * @param connection
     */
    public static  void releaseDB(Connection connection){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭数据库资源
     *
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public static void releaseDB2(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * INSERT , UPDATE , DELETE
     * @param connection ：数据库连接
     * @param sql        ： SQL语句
     * @param args       ： 填充占位符的可变参数
     */
    @Override
    public int update(Connection connection, String sql, Object... args) {
        connection = getConnection();
        int i = -1;
        try {
           i = queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return i;
        }

    }

    /**
     *
     * @param connection ： 数据库连接
     * @param sql ： SQL语句
     * @param args :填充占位符的可变参数
     * @return 返回具体的一个值
     * BeanHandler ： 把结果集的第一条记录转化为创建BeanHandler对象时传入的Class参数对应的对象
     */
    @Override
    public T get(Connection connection, String sql, Object... args) {
        T t = null;
        try {
            t = queryRunner.query(connection,sql,new BeanHandler<>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return t;
        }

    }

    /**
     *
     * @param connection ： 数据库连接
     * @param sql ：SQL语句
     * @param args ：填充占位符的可变参数
     * @return 返回一个T的集合
     * BeanListHandler ： 把结果集转化为一个List，该List不为null;但可能为空集合（sise（）方法返回0）
     */
    @Override
    public List<T> gets(Connection connection, String sql, Object... args) {
        List<T> t = null;

        try {
            t = queryRunner.query(connection,sql,new BeanListHandler<>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return t;
        }


    }

    /**
     *
     * @param connection
     * @param sql
     * @param args
     * @param <E>
     * @return
     * ScalarHandler ： 把结果集转化为一个数值返回
     */
    @Override
    public <E> E getValues(Connection connection, String sql, Object... args) {
        Object e = null;
        try {
            e = queryRunner.query(connection,sql,new ScalarHandler<>(),args);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return (E)e;
    }

    @Override
    public void batch(Connection connection, String sql, Object[]... args) {

    }

    /**
     * 提交事务
     * @param connection
     */
    public static void commit(Connection connection){
        if(connection != null){
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 回滚事务
     * @param connection
     */
    public static void rollback(Connection connection){
        if(connection != null){
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 开始事务
     * @param connection
     */
    public static  void beginTx(Connection connection){
        if(connection != null){
            try {
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
