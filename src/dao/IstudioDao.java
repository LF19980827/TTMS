package dao;

import entity.Iseat;
import entity.Istudio;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-23-13:06
 * 放映厅
 */
public interface IstudioDao {

    /**
     * 增加新演出厅
     * @param connection
     * @param istudio
     * @return 是否增加成功
     */
    public int insert(Connection connection, Istudio istudio);

    /**
     * 根据演出厅ID修改影厅信息
     * @param connection
     * @param istudio
     * @return 是否修改成功
     */
    public int update(Connection connection,Istudio istudio);

    /**
     * 根据演出厅名进行模糊查询
     * @param connection
     * @param istudio
     * @return 返回模糊查询的所有结果
     */
    public List<Istudio> select(Connection connection,Istudio istudio);

    /**
     * 返回所有演出厅信息
     * @param connection
     * @return
     */
    public List<Istudio> getAll(Connection connection);

    /**
     * 根据演出厅名称判断演出厅是否存在
     * @param connection
     * @param istudio
     * @return
     */
    public boolean isExist(Connection connection,Istudio istudio);

    /**
     * 根据演出厅名称精确查出演出厅信息
     * @param connection
     * @param istudio
     * @return 返回被查询的演出厅信息
     */
    public Istudio select2(Connection connection,Istudio istudio);
}
