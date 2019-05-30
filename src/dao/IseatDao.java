package dao;

import entity.Iplay;
import entity.Iseat;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-23-13:05
 * 座位信息
 */
public interface IseatDao {
    /**
     * 增加座位信息
     * @param connection
     * @param iseat
     * @return 是否增加成功
     */
    public int insert(Connection connection, Iseat iseat);

    /**
     * 根据座位ID修改信息
     * @param connection
     * @param iseat
     * @return 是否修改成功
     */
    public int update(Connection connection, Iseat iseat);

    /**
     * 根据座位ID查找座位
     * @param connection
     * @param iseat
     * @return 返回被查询座位的所有信息
     */
    public Iseat select(Connection connection, Iseat iseat);

    /**
     * 根据演出厅ID返回该演出厅的所有座位
     * @param connection
     * @param iseat
     * @return
     */
    public List<Iseat> getAll(Connection connection, Iseat iseat);

    /**
     * 根据座位ID判断座位是否存在
     * @param connection
     * @param iseat
     * @return 是否存在
     */
    public boolean isExist(Connection connection, Iseat iseat);
}
