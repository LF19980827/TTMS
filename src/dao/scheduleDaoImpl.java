package dao;

import Tools.DBUtils;
import entity.Ischedule;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-23-16:57
 */
public class scheduleDaoImpl extends DBUtils<Ischedule> implements IscheduleDao {
    /**
     * 增加演出计划
     * @param connection
     * @param ischedule
     * @return
     */
    @Override
    public int insert(Connection connection, Ischedule ischedule) {
        scheduleDaoImpl scheduleDao = new scheduleDaoImpl();
        String sql = "INSERT INTO schedule(studio_id,play_id,sched_time,sched_ticket_price) VALUES(?,?,?,?)";
        return scheduleDao.update(connection,sql,ischedule.getStudio_id(),ischedule.getPlay_id(),
                ischedule.getSched_time(),ischedule.getSched_ticket_price());
    }

    /**
     * 根据计划ID修改演出计划
     * @param connection
     * @param ischedule
     * @return
     */
    @Override
    public int update(Connection connection, Ischedule ischedule) {
        scheduleDaoImpl scheduleDao = new scheduleDaoImpl();
        String sql = "UPDATE schedule SET studio_id=?,play_id=?,sched_time=?,sched_ticket_price=? WHERE sched_id=?";
        return scheduleDao.update(connection,sql,ischedule.getStudio_id(),ischedule.getPlay_id(),ischedule.getSched_time(),
                ischedule.getSched_ticket_price(),ischedule.getSched_id());
    }

    /**
     * 根据计划ID删除演出计划
     * @param connection
     * @param ischedule
     * @return
     */
    @Override
    public int delete(Connection connection, Ischedule ischedule) {
        scheduleDaoImpl scheduleDao = new scheduleDaoImpl();
        String sql = "DELETE FROM schedule WHERE sched_id=?";
        return scheduleDao.update(connection,sql,ischedule.getSched_id());
    }

    /**
     * 根据计划ID查询演出计划
     * @param connection
     * @param ischedule
     * @return
     */
    @Override
    public Ischedule select(Connection connection, Ischedule ischedule) {
        scheduleDaoImpl scheduleDao = new scheduleDaoImpl();
        String sql = "SELECT * FROM schedule WHERE sched_id=?";
        return scheduleDao.get(connection,sql,ischedule.getSched_id());
    }

    /**
     * 返回所有演出计划
     * @param connection
     * @return
     */
    @Override
    public List<Ischedule> getAll(Connection connection) {
        scheduleDaoImpl scheduleDao = new scheduleDaoImpl();
        String sql = "SELECT * FROM schedule";
        return scheduleDao.gets(connection,sql,null);
    }

    /**
     * 根据计划ID判断演出计划是否存在
     * @param connection
     * @param ischedule
     * @return
     */
    @Override
    public boolean isExist(Connection connection, Ischedule ischedule) {
        scheduleDaoImpl scheduleDao = new scheduleDaoImpl();
        String sql = "SELECT * FROM schedule WHERE sched_id=?";
        ischedule = scheduleDao.get(connection,sql,ischedule.getSched_id());
        if(null == ischedule){
            return false;
        }
        return true;
    }

    /**
     * 根据演出厅ID，电影ID(必选)，演出时间查询演出计划
     * @param connection
     * @param ischedule
     * @return
     */
    @Override
    public List<Ischedule> gets(Connection connection, Ischedule ischedule) {
        scheduleDaoImpl scheduleDao = new scheduleDaoImpl();
        String sql = "SELECT * FROM schedule WHERE play_id=?";
        if(ischedule.getStudio_id() != 0){  //如果选择了演出厅ID
            sql = sql+"AND studio_id="+ischedule.getStudio_id();
        }
        if (ischedule.getSched_time() != null){
            sql =sql+"AND sched_time="+ischedule.getSched_time();
        }
        return scheduleDao.gets(connection,sql,null);
    }

    /**
     * 根据演出厅ID，电影ID，演出时间判断演出计划是否存在
     * @param connection
     * @param ischedule
     * @return
     */
    @Override
    public boolean isExist2(Connection connection, Ischedule ischedule) {
        scheduleDaoImpl scheduleDao = new scheduleDaoImpl();
        String sql = "SELECT * FROM schedule WHERE studio_id=? AND play_id=? AND sched_time=?";
        Ischedule ischedule1 = scheduleDao.get(connection,sql,ischedule.getStudio_id(),ischedule.getPlay_id(),ischedule.getSched_time());
        if (null == ischedule1){
            return false;
        }
        return true;
    }
}
