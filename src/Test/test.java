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




    //测试分页DAO层
   // @Test
    public void test2() {
        Connection connection = DBUtils.getConnection();
        PageDao<Istudio> pageDao = new PageDaoImpl();
        Map<String, String[]> map = new HashMap<>();
        String[] arr = new String[10];
        arr[0] = "";
        map.put("employee_name",arr);
        IemployeeDao Dao = new employeeDaoImpl();
        System.out.println(pageDao.judge(connection,"employee",map).size());
    }

    //测试分页service层
   // @Test
    public void test3(){
        PageSelect<Istudio> pageSelect = new PageSelectImpl();
        Map<String, String[]> map = new HashMap<>();
        String[] arr = new String[10];
        arr[0] = "";
        map.put("employee_name",arr);
        PageBean<Istudio> studioByPage =  pageSelect.findByPage(2,3,map,"employee");
        System.out.println(studioByPage);
    }


    public static void main(String[] args) {
        employeeDaoImpl employeeDao = new employeeDaoImpl();
        Connection connection = DBUtils.getConnection();
        Iemployee iemployee = new Iemployee();
        iemployee.setEmp_user("user");
        iemployee.setEmp_password("123456");
        Iemployee iemployee1 = employeeDao.login(connection, iemployee);
        System.out.println(iemployee1);
    }
}
