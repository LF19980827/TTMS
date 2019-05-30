package Test;

import Tools.DBUtils;
import dao.studioDaoImpl;
import entity.Istudio;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-25-22:28
 */
public class Test {

    public static void main(String[] args) {
        Connection connection = DBUtils.getConnection();
        studioDaoImpl studioDao = new studioDaoImpl();
        Istudio istudio = new Istudio();
        istudio.setStudio_name("钱");
        List<Istudio> select = studioDao.select(connection, istudio);
        System.out.println(select);
    }
}
