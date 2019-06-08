package dao;

import Tools.DBUtils;
import entity.Isale;
import entity.Isale;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-23-16:57
 */
public class saleDaoImpl extends DBUtils<Isale> implements IsaleDao {
    /**
     * 增加销售单
     * @param connection
     * @param isale
     * @return
     */
    @Override
    public int insert(Connection connection, Isale isale) {
        saleDaoImpl saleDao = new saleDaoImpl();
        String sql = "INSERT INTO sale(ticket_id,customer_id,sale_price,sale_status,sale_type,sale_time)VALUES(?,?,?,?,?,?)";
        return saleDao.update(connection,sql,isale.getTicket_id(),isale.getCustomer_id(),isale.getSale_price(),
                isale.getSale_status(),isale.getSale_type(),isale.getSale_time());
    }

    /**
     * 根据销售单ID更改状态
     * @param connection
     * @param isale
     * @return
     */
    @Override
    public int update(Connection connection, Isale isale) {
        saleDaoImpl saleDao = new saleDaoImpl();
        String sql = "UPDATE sale SET sale_status=? WHERE sale_id=?";
        return saleDao.update(connection,sql,isale.getSale_status(),isale.getSale_id());
    }

    /**
     * 根据销售单ID查询销售单信息
     * @param connection
     * @param isale
     * @return
     */
    @Override
    public Isale select(Connection connection, Isale isale) {
        saleDaoImpl saleDao = new saleDaoImpl();
        String sql = "SELECT * FROM sale WHERE sale_id=?";
        return saleDao.get(connection,sql,isale.getSale_id());
    }

    /**
     * 返回所有销售单
     * @param connection
     * @return
     */
    @Override
    public List<Isale> getAll(Connection connection) {
        saleDaoImpl saleDao = new saleDaoImpl();
        String sql = "SELECT * FROM sale";
        return saleDao.gets(connection,sql,null);
    }

    /**
     * 根据销售单ID判断是否存在
     * @param connection
     * @param isale
     * @return
     */
    @Override
    public boolean isExist(Connection connection, Isale isale) {
        saleDaoImpl saleDao = new saleDaoImpl();
        String sql = "SELECT * FROM sale WHERE sale_id=?";
        isale = saleDao.get(connection,sql,isale.getSale_id());
        if(null == isale){
            return false;
        }
        return  true;

    }
}
