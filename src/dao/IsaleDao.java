package dao;

import entity.Iemployee;
import entity.Isale;
import entity.Isale;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-23-13:05
 * 销售单信息
 */
public interface IsaleDao {

    /**
     * 增加新销售单
     * @param connection
     * @param isale_item
     * @return 是否增加成功
     */
    public int insert(Connection connection, Isale isale_item);

    /**
     * 根据销售单ID更改状态
     * @param connection
     * @param isale_item
     * @return 是否修改成功
     */
    public int update(Connection connection, Isale isale_item);

    /**
     * 根据销售单ID查询销售单信息
     * @param connection
     * @param isale_item
     * @return 返回被查询销售单信息
     */
    public Isale select(Connection connection, Isale isale_item);

    /**
     * 返回所有销售单信息
     * @param connection
     * @return
     */
    public List<Isale> getAll(Connection connection);

    /**
     * 根据销售单ID判断是否存在
     * @param connection
     * @param isale_item
     * @return 是否存在
     */
    public boolean isExist(Connection connection, Isale isale_item);
}
