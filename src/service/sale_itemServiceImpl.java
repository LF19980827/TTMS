package service;

import Tools.DBUtils;
import dao.Isale_itemDao;
import dao.sale_itemDaoImpl;
import entity.Isale_item;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-25-15:28
 */
public class sale_itemServiceImpl implements Isale__itemService {
    Connection connection = null;
    Isale_itemDao isale_itemDao = new sale_itemDaoImpl();

    /**
     * 增加销售单信息
     * @param isale_item
     * @return
     */
    @Override
    public int sale_itemInsert(Isale_item isale_item) {
        connection = DBUtils.getConnection();
        int i = -1;
        if(isale_itemDao.isExist(connection,isale_item)){
            return i;
        }
        i = isale_itemDao.insert(connection,isale_item);
        DBUtils.releaseDB(connection);
        return i;
    }

    /**
     * 根据销售单ID更新销售单状态
     * @param isale_item
     * @return
     */
    @Override
    public int sale_itemUpdate(Isale_item isale_item) {
        connection = DBUtils.getConnection();
        int i = -1;
        if(isale_itemDao.isExist(connection,isale_item)){
            i = isale_itemDao.update(connection,isale_item);
        }
        DBUtils.releaseDB(connection);
        return i;
    }

    /**
     * 根据销售单ID获取销售单信息
     * @param isale_item
     * @return
     */
    @Override
    public Isale_item sale_itemGet(Isale_item isale_item) {
        connection = DBUtils.getConnection();
        isale_item = isale_itemDao.select(connection,isale_item);
        DBUtils.releaseDB(connection);
        return isale_item;
    }

    /**
     * 返回所有销售单信息
     * @return
     */
    @Override
    public List<Isale_item> sale_itemGetAll() {
        connection = DBUtils.getConnection();
        List<Isale_item> isale_items = isale_itemDao.getAll(connection);
        DBUtils.releaseDB(connection);
        return isale_items;
    }
}
