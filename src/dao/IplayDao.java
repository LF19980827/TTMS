package dao;

import entity.Iemployee;
import entity.Iplay;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-23-13:04
 * 电影信息
 */
public interface IplayDao {

    /**
     * 增加新电影
     * @param connection
     * @param iplay
     * @return 是否增加成功
     */
    public int insert(Connection connection, Iplay iplay);

    /**
     * 根据电影ID修改电影信息
     * @param connection
     * @param iplay
     * @return 是否修改成功
     */
    public int update(Connection connection, Iplay iplay);

    /**
     * 根据电影ID查询电影信息
     * @param connection
     * @param iplay
     * @return 返回被查询电影的所有信息
     */
    public Iplay select(Connection connection, Iplay iplay);

    /**
     * 返回所有电影信息
     * @param connection
     * @return 所有电影信息
     */
    public List<Iplay> getAll(Connection connection);

    /**
     * 根据电影ID判断电影是否存在
     * @param connection
     * @param iplay
     * @return 是否存在
     */
    public boolean isExist(Connection connection, Iplay iplay);

    /**
     * 根据电影ID修改电影状态
     * @param connection
     * @param iplay
     * @return
     */
    public int update2(Connection connection , Iplay iplay);
}
