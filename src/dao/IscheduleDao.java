package dao;

import entity.Iemployee;
import entity.Iplay;
import entity.Ischedule;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-23-13:05
 * 放映计划
 */
public interface IscheduleDao {

    /**
     * 增加演出计划
     * @param connection
     * @param ischedule
     * @return 是否增加成功
     */
    public int insert(Connection connection, Ischedule ischedule);

    /**
     * 根据计划ID修改演出计划
     * @param connection
     * @param ischedule
     * @return 是否修改成功
     */
    public int update(Connection connection, Ischedule ischedule);

    /**
     * 根据计划ID删除演出计划
     * @param connection
     * @param ischedule
     * @return 是否删除成功
     */
    public int delete(Connection connection, Ischedule ischedule);

    /**
     * 根据计划ID查询演出计划
     * @param connection
     * @param ischedule
     * @return 返回被查询的演出计划
     */
    public Ischedule select(Connection connection, Ischedule ischedule);

    /**
     * 返回所有演出计划
     * @param connection
     * @return 返回所有演出计划信息
     */
    public List<Ischedule> getAll(Connection connection);

    /**
     * 根据计划ID判断演出计划是否存在
     * @param connection
     * @param ischedule
     * @return 是否存在
     */
    public boolean isExist(Connection connection, Ischedule ischedule);

    /**
     * 根据演出厅ID，电影ID(必选)，演出时间查询演出计划
     * @param connection
     * @param ischedule
     * @return 返回被查询演出计信息
     */
    public List<Ischedule> gets(Connection connection, Ischedule ischedule);

    /**
     * 根据演出厅ID，电影ID，演出时间判断演出计划是否存在
     * @param connection
     * @param ischedule
     * @return 是否存在
     */
    public boolean isExist2(Connection connection, Ischedule ischedule);

}
