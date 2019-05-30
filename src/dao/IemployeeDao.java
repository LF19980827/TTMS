package dao;

import entity.Iemployee;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-23-10:46
 * 员工
 */
public interface IemployeeDao {
    /**
     * 增加新员工
     * @param connection
     * @param iemployee
     * @return 是否增加成功
     */
    public int insert(Connection connection, Iemployee iemployee);

    /**
     * 根据工号修改员工信息
     * @param connection
     * @param iemployee
     * @return 是否修改成功
     */
    public int update(Connection connection, Iemployee iemployee);

    /**
     * 根据工号删除员工信息
     * @param connection
     * @param iemployee
     * @return 是否删除成功
     */
    public int delete(Connection connection, Iemployee iemployee);

    /**
     * 根据工号查询员工
     * @param connection
     * @param iemployee
     * @return 返回被查询员工信息
     */
    public Iemployee select(Connection connection, Iemployee iemployee);

    /**
     * 查询所有员工信息
     * @param connection
     * @return 所有员工信息
     */
    public List<Iemployee> getAll(Connection connection);

    /**
     * 根据工号判断员工是否存在
     * @param connection
     * @param iemployee
     * @return 是否存在
     */
    public boolean isExist(Connection connection, Iemployee iemployee);

    /**
     * 员工登录验证
     * @param connection
     * @param iemployee
     * @return 如果成功则返回所有员工信息
     */
    public Iemployee login(Connection connection, Iemployee iemployee);
}
