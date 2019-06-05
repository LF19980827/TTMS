package service;

import Tools.DBUtils;
import dao.IemployeeDao;
import dao.employeeDaoImpl;
import entity.Iemployee;

import java.sql.Connection;
import java.util.List;

public class employessServiceImpl implements IemployeeService {


    Connection connection = DBUtils.getConnection();
    IemployeeDao iemployeeDao = new employeeDaoImpl();
    @Override
    public Iemployee login(Iemployee iemployee) {
        return iemployeeDao.login(connection,iemployee);
    }

    @Override
    public int employeeInsert(Iemployee iemployee) {
        return 0;
    }

    @Override
    public int employeeUpdate(Iemployee iemployee) {
        return 0;
    }

    @Override
    public int employeeDelete(Iemployee iemployee) {
        return 0;
    }

    @Override
    public Iemployee employeeGet(Iemployee iemployee) {
        return null;
    }

    @Override
    public List<Iemployee> employeeGets() {
        return null;
    }


}
