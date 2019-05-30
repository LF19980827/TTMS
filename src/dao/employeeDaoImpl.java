package dao;

import Tools.DBUtils;
import entity.Iemployee;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-23-10:50
 */
public class employeeDaoImpl extends DBUtils<Iemployee> implements IemployeeDao{

    /**
     * 增加新员工
     * @param connection
     * @param iemployee
     * @return
     */
    @Override
    public int insert(Connection connection, Iemployee iemployee) {
        employeeDaoImpl employeeDao = new employeeDaoImpl();
        String sql = "INSERT INTO employee(emp_no,emp_name,emp_tel_num,emp_addr,emp_email,emp_user,emp_password) VALUES(?,?,?,?,?,?,?)";
        return employeeDao.update(connection,sql, iemployee.getEmp_no(),iemployee.getEmp_name(),iemployee.getEmp_tel_num(),
                iemployee.getEmp_addr(),iemployee.getEmp_email(),iemployee.getEmp_user(),iemployee.getEmp_password());
    }

    /**
     * 根据工号修改员工信息
     * @param connection
     * @param iemployee
     * @return
     */
    @Override
    public int update(Connection connection, Iemployee iemployee){
        employeeDaoImpl employeeDao = new employeeDaoImpl();
        String sql = "UPDATE employee SET emp_name=?,emp_tel_num=?,emp_addr=?,emp_email=?,emp_user=?,emp_password=? WHERE emp_no=?";
        return employeeDao.update(connection,sql,iemployee.getEmp_name(),iemployee.getEmp_tel_num(),iemployee.getEmp_addr(),
                iemployee.getEmp_email(),iemployee.getEmp_user(),iemployee.getEmp_password(),iemployee.getEmp_no());
    }

    /**
     * 根据工号删除员工
     * @param connection
     * @param iemployee
     * @return
     */
    @Override
    public int delete(Connection connection, Iemployee iemployee) {
        employeeDaoImpl employeeDao = new employeeDaoImpl();
        String sql = "DELETE FROM employee WHERE emp_no=?";
        return employeeDao.update(connection,sql,iemployee.getEmp_no());
    }

    /**
     * 根据工号查询员工
     * @param connection
     * @param iemployee
     * @return
     */
    @Override
    public Iemployee select(Connection connection, Iemployee iemployee) {
        employeeDaoImpl employeeDao = new employeeDaoImpl();
        String sql = "SELECT * FROM employee WHERE emp_no=?";
        return employeeDao.get(connection,sql,iemployee.getEmp_no());
    }

    /**
     * 返回所有员工信息
     * @param connection
     * @return
     */
    @Override
    public List<Iemployee> getAll(Connection connection) {
        employeeDaoImpl employeeDao = new employeeDaoImpl();
        String sql ="SELECT * FROM employee";
        return employeeDao.gets(connection,sql,null);
    }

    /**
     * 根据工号判断员工是否存在
     * @param connection
     * @param iemployee
     * @return
     */
    @Override
    public boolean isExist(Connection connection, Iemployee iemployee) {
        employeeDaoImpl employeeDao = new employeeDaoImpl();
        String sql = "SELECT * FROM employee WHERE emp_no=?";
        iemployee = employeeDao.get(connection,sql,iemployee.getEmp_no());
        if (null == iemployee){
            return false;
        }
       return true;
    }

    /**
     * 登陆
     * @param connection
     * @param iemployee
     * @return
     */
    @Override
    public Iemployee login(Connection connection, Iemployee iemployee) {
        employeeDaoImpl employeeDao = new employeeDaoImpl();
        String sql = "SELECT * FROM employee WHERE emp_user = ? and emp_password = ? ";
        return employeeDao.get(connection,sql,iemployee.getEmp_user(),iemployee.getEmp_password());
    }
}
