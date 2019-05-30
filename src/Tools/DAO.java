package Tools;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-18-22:32
 * 访问数据的DAO接口
 * @param  T : DAO处理的实体的类型
 */
public interface DAO<T> {

    /**
     * INSERT , UPDATE , DELETE
     *
     * @param connection ：数据库连接
     * @param sql        ： SQL语句
     * @param args       ： 填充占位符的可变参数
     */
    int update(Connection connection, String sql, Object... args);

    /**
     * 返回一个T对象
     * @param connection ： 数据库连接
     * @param sql ： SQL语句
     * @param args :填充占位符的可变参数
     * @return 返回一个T对象
     */
    T get(Connection connection, String sql, Object... args);

    /**
     * 返回具体的一个值
     * @param connection ： 数据库连接
     * @param sql ：SQL语句
     * @param args ：填充占位符的可变参数
     * @return 返回具体的一个值
     */
    List<T> gets(Connection connection, String sql, Object... args);

    /**
     * 返回T的一个集合
     * @param connection
     * @param sql
     * @param args
     * @param <E>
     * @return 返回一个T的集合
     */
    <E> E getValues(Connection connection, String sql, Object... args);

    /**
     * 批量处理的方法
     * @param connection
     * @param sql
     * @param args ：填充占位符的Object[]类型的可变参数
     */
    void batch(Connection connection, String sql, Object[]... args);
}
