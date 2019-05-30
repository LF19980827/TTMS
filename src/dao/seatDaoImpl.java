package dao;

import Tools.DBUtils;
import entity.Iseat;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-23-16:57
 */
public class seatDaoImpl extends DBUtils<Iseat> implements IseatDao {
    /**
     * 增加座位信息
     * @param connection
     * @param iseat
     * @return
     */
    @Override
    public int insert(Connection connection, Iseat iseat) {
        seatDaoImpl seatDao = new seatDaoImpl();
        String sql = "INSERT INTO seat(studio_id,seat_row,seat_column,seat_status) VALUES(?,?,?,?)";
        return seatDao.update(connection,sql,iseat.getStudio_id(),iseat.getSeat_row(),
                iseat.getSeat_column(),iseat.getSeat_status());
    }

    /**
     * 根据座位ID修改信息
     * @param connection
     * @param iseat
     * @return
     */
    @Override
    public int update(Connection connection, Iseat iseat) {
        seatDaoImpl seatDao = new seatDaoImpl();
        String sql = "UPDATE seat SET seat_status=? WHERE seat_id=?";
        return seatDao.update(connection,sql,iseat.getSeat_status(),iseat.getSeat_id());
    }

    /**
     * 根据座位ID查找座位
     * @param connection
     * @param iseat
     * @return
     */
    @Override
    public Iseat select(Connection connection, Iseat iseat) {
        seatDaoImpl seatDao = new seatDaoImpl();
        String sql = "SELECT * FROM seat WHERE seat_id=?";
        return seatDao.get(connection,sql,iseat.getSeat_id());
    }

    /**
     * 根据演出厅ID返回该演出厅的所有座位
     * @param connection
     * @param iseat
     * @return
     */
    @Override
    public List<Iseat> getAll(Connection connection,Iseat iseat) {
        seatDaoImpl seatDao = new seatDaoImpl();
        String sql = "SELECT * FROM seat WHERE studio_id=?";
        return seatDao.gets(connection,sql,iseat.getStudio_id());
    }

    /**
     * 根据座位ID判断座位是否存在
     * @param connection
     * @param iseat
     * @return
     */
    @Override
    public boolean isExist(Connection connection, Iseat iseat) {
        seatDaoImpl seatDao = new seatDaoImpl();
        String sql = "SELECT * FROM seat WHERE seat_id=?";
        iseat = seatDao.get(connection,sql,iseat.getSeat_id());
        if(null == iseat){
            return false;
        }
        return true;
    }
}
