package dao;

import Tools.DBUtils;
import entity.Iplay;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-23-16:56
 */
public class playDaoImpl extends DBUtils<Iplay> implements IplayDao {
    /**
     * 增加电影
     * @param connection
     * @param iplay
     * @return
     */
    @Override
    public int insert(Connection connection, Iplay iplay) {
        playDaoImpl playDao = new playDaoImpl();
        String sql="INSERT INTO play(play_type_id,play_lang_id,play_name,play_introduction,play_length,play_ticket_price,play_status)VALUES(?,?,?,?,?,?,?)";
        return playDao.update(connection,sql,iplay.getPlay_type_id(),iplay.getPlay_lang_id(),iplay.getPlay_name(),
                iplay.getPlay_introduction(),iplay.getPlay_length(),iplay.getPlay_ticket_price(),iplay.getPlay_status());
    }

    /**
     * 根据电影ID修改电影信息
     * @param connection
     * @param iplay
     * @return
     */
    @Override
    public int update(Connection connection, Iplay iplay) {
        playDaoImpl playDao = new playDaoImpl();
        String sql="UPDATE play SET play_type_id=?,play_lang_id=?,play_name=?,play_introduction=?,play_length=?,play_ticket_price=? WHERE play_id=?";
        return playDao.update(connection,sql,iplay.getPlay_type_id(),iplay.getPlay_lang_id(),iplay.getPlay_name(),
                iplay.getPlay_introduction(),iplay.getPlay_length(),iplay.getPlay_ticket_price(),iplay.getPlay_id());
    }

    /**
     *根据电影ID查询电影
     * @param connection
     * @param iplay
     * @return
     */
    @Override
    public Iplay select(Connection connection, Iplay iplay) {
        playDaoImpl playDao = new playDaoImpl();
        String sql="SELECT * FROM play WHERE play_id=?";
        return playDao.get(connection,sql,iplay.getPlay_id());
    }

    /**
     * 返回所有电影
     * @param connection
     * @return
     */
    @Override
    public List<Iplay> getAll(Connection connection) {
        playDaoImpl playDao = new playDaoImpl();
        String sql="SELECT * FROM play";
        return playDao.gets(connection,sql,null);
    }

    /**
     * 根据电影ID判断电影是否存在
     * @param connection
     * @param iplay
     * @return
     */
    @Override
    public boolean isExist(Connection connection, Iplay iplay) {
        playDaoImpl playDao = new playDaoImpl();
        String sql="SELECT * FROM play WHERE play_id=?";
        iplay = playDao.get(connection,sql,iplay.getPlay_id());
        if(null == iplay){
            return false;
        }
       return true;
    }

    /**
     * 根据电影ID修改电影状态
     * @param connection
     * @param iplay
     * @return
     */
    @Override
    public int update2(Connection connection, Iplay iplay) {
        playDaoImpl playDao = new playDaoImpl();
        String sql="UPDATE play SET play_status=? WHERE play_id=?";
        playDao.update(connection,sql,iplay.getPlay_status(),iplay.getPlay_id());
        return 0;
    }


}
