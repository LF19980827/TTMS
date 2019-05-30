package dao;

import Tools.DBUtils;
import entity.Icustomer;

import java.sql.Connection;

/**
 * @author LFuser
 * @create 2019-05-23-16:55
 */
public class customerDaoImpl extends DBUtils<Icustomer> implements IcustomerDao {
    /**
     * 增加新用户
     * @param connection
     * @param icustomer
     * @return
     */
    @Override
    public int insert(Connection connection, Icustomer icustomer) {
        customerDaoImpl customerDao =new customerDaoImpl();
        String sql = "INSERT INTO customer(customer_user,customer_password,customer_email,customer_money,customer_tel,customer_name) VALUES(?,?,?,?,?,?)";
        return customerDao.update(connection,sql,icustomer.getCustomer_user(),icustomer.getCustomer_password(),icustomer.getCustomer_email(),
                icustomer.getCustomer_money(),icustomer.getCustomer_tel(),icustomer.getCustomer_name());
    }

    /**
     * 根据用户名修改用户信息
     * @param connection
     * @param icustomer
     * @return
     */
    @Override
    public int update(Connection connection, Icustomer icustomer) {
        customerDaoImpl customerDao =new customerDaoImpl();
        String sql = "UPDATE customer SET customer_password=?,customer_email=?,customer_money=?,customer_tel=?,customer_name=? WHERE customer_user=?";
        return customerDao.update(connection,sql,icustomer.getCustomer_password(),icustomer.getCustomer_email(),icustomer.getCustomer_money(),
                icustomer.getCustomer_tel(),icustomer.getCustomer_name(),icustomer.getCustomer_user());
    }

    /**
     * 根据用户名查询用户
     * @param connection
     * @param icustomer
     * @return
     */
    @Override
    public Icustomer select(Connection connection, Icustomer icustomer) {
        customerDaoImpl customerDao =new customerDaoImpl();
        String sql = "SELECT * FROM customer WHERE customer_user=?";
        return customerDao.get(connection,sql,icustomer.getCustomer_user());
    }

    /**
     * 根据用户名查询是否存在
     * @param connection
     * @param icustomer
     * @return
     */
    @Override
    public boolean isExist(Connection connection, Icustomer icustomer) {
        customerDaoImpl customerDao =new customerDaoImpl();
        String sql = "SELECT * FROM customer WHERE customer_user=?";
        icustomer = customerDao.get(connection,sql,icustomer.getCustomer_user());
        if(null == icustomer){
            return false;
        }
        return true;
    }

    /**
     * 用户登陆验证
     * @param connection
     * @param icustomer
     * @return
     */
    @Override
    public Icustomer login(Connection connection, Icustomer icustomer) {
        customerDaoImpl customerDao = new customerDaoImpl();
        String sql = "SELECT * FROM customer WHERE customer_user=? AND customer_password=?";
        return customerDao.get(connection,sql,icustomer.getCustomer_user(),icustomer.getCustomer_password());
    }
}
