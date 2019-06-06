package dao;

import Tools.DBUtils;
import entity.Iseat;
import entity.Istudio;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author LFuser
 * @create 2019-05-23-16:58
 */
public class studioDaoImpl extends DBUtils<Istudio> implements IstudioDao {
    /**
     * 增加演出厅
     * @param connection
     * @param istudio
     * @return
     */
    @Override
    public int insert(Connection connection, Istudio istudio) {

        studioDaoImpl studioDao = new studioDaoImpl();
        String sql = "INSERT INTO studio (studio_name,studio_row_count,studio_col_count,studio_introduction) VALUES(?,?,?,?)";

        int i = studioDao.update(connection, sql, istudio.getStudio_name(), istudio.getStudio_row_count(),
                istudio.getStudio_col_count(), istudio.getStudio_introduction());

        sql = "select * from studio where studio_name = ?";
        istudio = studioDao.get(connection,sql,istudio.getStudio_name());

        insertSeat(connection,istudio);

        return i;
    }

    /**
     * 根据演出厅ID修改演出厅信息
     * @param connection
     * @param istudio
     * @return
     */
    @Override
    public int update(Connection connection, Istudio istudio) {
        studioDaoImpl studioDao = new studioDaoImpl();
        String sql = "UPDATE studio SET studio_name=?,studio_row_count=?,studio_col_count=?,studio_introduction=? WHERE studio_id=?";
        return studioDao.update(connection,sql,istudio.getStudio_name(),istudio.getStudio_row_count(),istudio.getStudio_col_count(),
                istudio.getStudio_introduction(),istudio.getStudio_id());
    }

    /**
     * 根据演出厅名称查询演出厅信息
     * @param connection
     * @param istudio
     * @return
     */
    @Override
    public List<Istudio> select(Connection connection, Istudio istudio) {
        studioDaoImpl studioDao = new studioDaoImpl();
        String sql = "SELECT * FROM studio WHERE studio_name like '%"+istudio.getStudio_name()+"%'";
        return studioDao.gets(connection,sql);
    }

    /**
     * 返回所有演出厅
     * @param connection
     * @return
     */
    @Override
    public List<Istudio> getAll(Connection connection) {
        studioDaoImpl studioDao = new studioDaoImpl();
        String sql = "SELECT * FROM studio";
        return studioDao.gets(connection,sql,null);
    }

    /**
     * 根据演出厅名称判断演出厅是否存在
     * @param connection
     * @param istudio
     * @return
     */
    @Override
    public boolean isExist(Connection connection, Istudio istudio) {
        studioDaoImpl studioDao = new studioDaoImpl();
        String sql = "SELECT * FROM studio WHERE studio_name =?";
        istudio = studioDao.get(connection,sql,istudio.getStudio_name());
        if(null == istudio){
            return false;
        }
        return true;
    }

    /**
     * 根据演出厅名称精确查询演出厅信息
     * @param connection
     * @param istudio
     * @return
     */
    @Override
    public Istudio select2(Connection connection, Istudio istudio) {
        studioDaoImpl studioDao = new studioDaoImpl();
        String sql = "SELECT * FROM studio WHERE studio_name =?";
        return studioDao.get(connection,sql,istudio.getStudio_name());
    }

    public Istudio select3(Connection connection, Istudio istudio){
        studioDaoImpl studioDao = new studioDaoImpl();
        String sql = "SELECT * FROM studio WHERE studio_id =?";
        return studioDao.get(connection,sql,istudio.getStudio_id());
    }

    /**
     * 创建演出厅的时候增加座位
     * @param connection
     * @param istudio
     */
    private void insertSeat(Connection connection, Istudio istudio) {
        Iseat iseat = new Iseat();
        seatDaoImpl seatDao = new seatDaoImpl();
        for (int i = 1; i <= istudio.getStudio_row_count(); i++) {
            for (int j = 1; j <= istudio.getStudio_col_count(); j++) {
                iseat.setSeat_row(i);
                iseat.setSeat_column(j);
                iseat.setStudio_id(istudio.getStudio_id());
                seatDao.insert(connection,iseat);
            }
        }
    }


}
