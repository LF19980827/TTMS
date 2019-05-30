package service;

import Tools.DBUtils;
import dao.IcustomerDao;
import dao.customerDaoImpl;
import entity.Icustomer;

import java.sql.Connection;

/**
 * @author LFuser
 * @create 2019-05-25-14:47
 */
public class customerServiceImpl implements IcustomerService {
    Connection connection = null;
    IcustomerDao icustomerDao = new customerDaoImpl();

    /**
     * 用户登陆验证
     * @param icustomer
     * @return
     */
    @Override
    public Icustomer login(Icustomer icustomer) {
        connection = DBUtils.getConnection();
        icustomer = icustomerDao.login(connection,icustomer);
        DBUtils.releaseDB(connection);
        return icustomer;
    }

    /**
     * 增加用户
     * @param icustomer
     * @return
     */
    @Override
    public int customerInsert(Icustomer icustomer) {
        int i = -1;
        connection = DBUtils.getConnection();
        if(icustomerDao.isExist(connection,icustomer)){
            return i;
        }
        i = icustomerDao.insert(connection,icustomer);
        DBUtils.releaseDB(connection);
        return i;
    }

    /**
     * 修改用户信息
     * @param icustomer
     * @return
     */
    @Override
    public int customerUpdate(Icustomer icustomer) {
        connection = DBUtils.getConnection();
        int i = -1;
        if(icustomerDao.isExist(connection,icustomer)){
            i = icustomerDao.update(connection,icustomer);
        }
        DBUtils.releaseDB(connection);
        return i;
    }
}
