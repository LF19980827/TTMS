package service;

import Tools.DBUtils;
import dao.IsaleDao;
import dao.saleDaoImpl;
import entity.Isale;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-25-15:28
 */
public class saleServiceImpl implements IsaleService {
    Connection connection = null;
    IsaleDao isaleDao = new saleDaoImpl();

    /**
     * 增加销售单信息
     * @param isale
     * @return
     */
    @Override
    public int saleInsert(Isale isale) {
        connection = DBUtils.getConnection();
        int i = -1;
        if(isaleDao.isExist(connection,isale)){
            return i;
        }
        i = isaleDao.insert(connection,isale);
        DBUtils.releaseDB(connection);
        return i;
    }

    /**
     * 根据销售单ID更新销售单状态
     * @param isale
     * @return
     */
    @Override
    public int saleUpdate(Isale isale) {
        connection = DBUtils.getConnection();
        int i = -1;
        if(isaleDao.isExist(connection,isale)){
            i = isaleDao.update(connection,isale);
        }
        DBUtils.releaseDB(connection);
        return i;
    }

    /**
     * 根据销售单ID获取销售单信息
     * @param isale
     * @return
     */
    @Override
    public Isale saleGet(Isale isale) {
        connection = DBUtils.getConnection();
        isale = isaleDao.select(connection,isale);
        DBUtils.releaseDB(connection);
        return isale;
    }

    /**
     * 返回所有销售单信息
     * @return
     */
    @Override
    public List<Isale> saleGetAll() {
        connection = DBUtils.getConnection();
        List<Isale> isales = isaleDao.getAll(connection);
        DBUtils.releaseDB(connection);
        return isales;
    }
}
