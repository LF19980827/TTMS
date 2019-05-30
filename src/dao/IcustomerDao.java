package dao;

import entity.Icustomer;
import entity.Iemployee;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-23-13:03
 * 用户
 */
public interface IcustomerDao {

    /**
     * 增加用户
     * @param connection
     * @param icustomer
     * @return 是否增加成功
     */
    public int insert(Connection connection, Icustomer icustomer);

    /**
     * 根据用户名修改用户信息
     * @param connection
     * @param icustomer
     * @return 是否修改成功
     */
    public int update(Connection connection, Icustomer icustomer);

    /**
     * 根据用户名查询用户信息
     * @param connection
     * @param icustomer
     * @return 被查询的用户信息
     */
    public Icustomer select(Connection connection, Icustomer icustomer);

    /**
     * 根据用户名判断用户是否存在
     * @param connection
     * @param icustomer
     * @return 是否用户存在
     */
    public boolean isExist(Connection connection, Icustomer icustomer);

    /**
     * 用户登陆验证
     * @param connection
     * @param icustomer
     * @return 如果验证成功则返回用户所有信息
     */
    public Icustomer login(Connection connection, Icustomer icustomer);
}
