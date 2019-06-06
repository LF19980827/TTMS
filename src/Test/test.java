package Test;
import Tools.DBUtils;
import dao.*;
import entity.Iemployee;
import entity.Istudio;
import entity.PageBean;
import service.PageSelect;
import service.PageSelectImpl;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Connection connection = DBUtils.getConnection();
        Iemployee iemployee = new Iemployee();
        iemployee.setEmp_no("3139");
        iemployee.setEmp_name("丰");
        iemployee.setEmp_tel_num("12345678911");
        iemployee.setEmp_addr("XUPT");
        iemployee.setEmp_email("2@qq.com");
        iemployee.setEmp_user("feng");
        iemployee.setEmp_password("123");

        employeeDaoImpl employeeDao = new employeeDaoImpl();
        employeeDao.insert(connection,iemployee);
    }
}
