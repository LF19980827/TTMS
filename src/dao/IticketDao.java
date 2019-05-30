package dao;

import entity.Istudio;
import entity.Iticket;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-23-13:06
 * 演出票
 */
public interface IticketDao {
    /**
     * 增加演出票信息
     * @param connection
     * @param iticket
     * @return 是否增加成功
     */
    public int insert(Connection connection, Iticket iticket);

    /**
     * 根据演出票ID修改演出票信息
     * @param connection
     * @param iticket
     * @return 是否修改成功
     */
    public int update(Connection connection, Iticket iticket);

    /**
     * 根据演出票ID查询演出票信息
     * @param connection
     * @param iticket
     * @return 返回被查询演出票的所有信息
     */
    public Iticket select(Connection connection, Iticket iticket);

    /**
     * 根据演出计划返回所有演出票的信息
     * @param connection
     * @param iticket
     * @return 返回该演出计划的所有演出票信息
     */
    public List<Iticket> getAll(Connection connection, Iticket iticket);

    /**
     * 根据演出票ID判断是否存在
     * @param connection
     * @param iticket
     * @return 是否存在
     */
    public boolean isExist(Connection connection, Iticket iticket);

}
