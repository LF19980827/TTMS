package Test;
import Tools.DBUtils;
import dao.*;
import entity.*;
import service.PageSelect;
import service.PageSelectImpl;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class test {
//    public static void main(String[] args) {
//        Connection connection = DBUtils.getConnection();
//        Iemployee iemployee = new Iemployee();
//        iemployee.setEmp_no("3139");
//        iemployee.setEmp_name("丰");
//        iemployee.setEmp_tel_num("12345678911");
//        iemployee.setEmp_addr("XUPT");
//        iemployee.setEmp_email("2@qq.com");
//        iemployee.setEmp_user("feng");
//        iemployee.setEmp_password("123");
//
//        employeeDaoImpl employeeDao = new employeeDaoImpl();
//        employeeDao.insert(connection,iemployee);
//    }

    public static void main(String[] args) {
        //测试生成演出计划同时生成相同的演出票
        Connection connection = DBUtils.getConnection();


        Iplay iplay = new Iplay();
        iplay.setPlay_type_id(1);
        iplay.setPlay_lang_id(4);
        iplay.setPlay_name("复联四");
        iplay.setPlay_introduction("暂无");
        iplay.setPlay_length(180);
        iplay.setPlay_ticket_price(90);
        iplay.setPlay_status(1);
        playDaoImpl playDao = new playDaoImpl();
        playDao.insert(connection,iplay);


        DBUtils.releaseDB(connection);
    }
}
