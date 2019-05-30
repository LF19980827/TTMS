package dao;

import Tools.DBUtils;
import entity.Isale_item;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-23-16:57
 */
public class sale_itemDaoImpl extends DBUtils<Isale_item> implements Isale_itemDao {
    /**
     * 增加销售单
     * @param connection
     * @param isale_item
     * @return
     */
    @Override
    public int insert(Connection connection, Isale_item isale_item) {
        sale_itemDaoImpl sale_itemDao = new sale_itemDaoImpl();
        String sql = "INSERT INTO sale_item(ticket_id,customer_id,sale_item_price,sale_status,sale_type,sale_time)VALUES(?,?,?,?,?,?)";
        return sale_itemDao.update(connection,sql,isale_item.getTicket_id(),isale_item.getCustomer_id(),isale_item.getSale_item_price(),
                isale_item.getSale_status(),isale_item.getSale_type(),isale_item.getSale_time());
    }

    /**
     * 根据销售单ID更改状态
     * @param connection
     * @param isale_item
     * @return
     */
    @Override
    public int update(Connection connection, Isale_item isale_item) {
        sale_itemDaoImpl sale_itemDao = new sale_itemDaoImpl();
        String sql = "UPDATE sale_item SET sale_status=? WHERE sale_item_id=?";
        return sale_itemDao.update(connection,sql,isale_item.getSale_status(),isale_item.getSale_item_id());
    }

    /**
     * 根据销售单ID查询销售单信息
     * @param connection
     * @param isale_item
     * @return
     */
    @Override
    public Isale_item select(Connection connection, Isale_item isale_item) {
        sale_itemDaoImpl sale_itemDao = new sale_itemDaoImpl();
        String sql = "SELECT * FROM sale_item WHERE sale_item_id=?";
        return sale_itemDao.get(connection,sql,isale_item.getSale_item_id());
    }

    /**
     * 返回所有销售单
     * @param connection
     * @return
     */
    @Override
    public List<Isale_item> getAll(Connection connection) {
        sale_itemDaoImpl sale_itemDao = new sale_itemDaoImpl();
        String sql = "SELECT * FROM sale_item";
        return sale_itemDao.gets(connection,sql,null);
    }

    /**
     * 根据销售单ID判断是否存在
     * @param connection
     * @param isale_item
     * @return
     */
    @Override
    public boolean isExist(Connection connection, Isale_item isale_item) {
        sale_itemDaoImpl sale_itemDao = new sale_itemDaoImpl();
        String sql = "SELECT * FROM sale_item WHERE sale_item_id=?";
        isale_item = sale_itemDao.get(connection,sql,isale_item.getSale_item_id());
        if(null == isale_item){
            return false;
        }
        return  true;

    }
}
