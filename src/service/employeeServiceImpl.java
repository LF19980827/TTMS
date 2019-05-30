package service;

import Tools.DBUtils;
import dao.IemployeeDao;
import dao.IstudioDao;
import dao.employeeDaoImpl;
import dao.studioDaoImpl;
import entity.Iemployee;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-24-15:20
 */
public class employeeServiceImpl implements IemployeeService{
    Connection connection =null;
    IemployeeDao iemployeeDao = new employeeDaoImpl();

    /**
     * 员工登陆
     * @param iemployee
     * @return
     */
    @Override
    public Iemployee login(Iemployee iemployee) {
        connection = DBUtils.getConnection();
        iemployee = iemployeeDao.login(connection,iemployee);
        DBUtils.releaseDB(connection);
        return iemployee;
    }

    /**
     * 增加新员工信息
     * @param iemployee
     * @return
     */
    @Override
    public int employeeInsert(Iemployee iemployee) {
        connection = DBUtils.getConnection();
        int i = -1;
        if(iemployeeDao.isExist(connection,iemployee)){
            return i;
        }
        i = iemployeeDao.insert(connection,iemployee);
        DBUtils.releaseDB(connection);
        return i;
    }

    /**
     * 修改员工信息
     * @param iemployee
     * @return
     */
    @Override
    public int employeeUpdate(Iemployee iemployee) {
        connection = DBUtils.getConnection();
        int i = -1;
        if(iemployeeDao.isExist(connection,iemployee)){  //如果存在则修改
            i = iemployeeDao.update(connection,iemployee);
        }
        DBUtils.releaseDB(connection);
        return i;
    }

    @Override
    public int employeeDelete(Iemployee iemployee) {
        connection = DBUtils.getConnection();
        int i = -1;
        if(iemployeeDao.isExist(connection,iemployee)){  //如果存在则删除
            i = iemployeeDao.delete(connection,iemployee);
        }
        DBUtils.releaseDB(connection);
        return i;
    }

    /**
     * 删除员工信息
     * @param iemployee
     * @return
     */
    @Override
    public Iemployee employeeGet(Iemployee iemployee) {
        connection = DBUtils.getConnection();
        iemployee = iemployeeDao.select(connection,iemployee);
        DBUtils.releaseDB(connection);
        return iemployee;
    }

    /**
     * 返回所有员工信息
     * @return
     */
    @Override
    public List<Iemployee> employeeGets() {
        connection = DBUtils.getConnection();
        List<Iemployee> iemployees = iemployeeDao.getAll(connection);
        DBUtils.releaseDB(connection);
        return iemployees;
    }
}
