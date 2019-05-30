package service;

import Tools.DBUtils;
import dao.IscheduleDao;
import dao.scheduleDaoImpl;
import entity.Ischedule;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-25-15:55
 */
public class scheduleServiceImpl implements IscheduleService {
    Connection connection = null;
    IscheduleDao ischeduleDao = new scheduleDaoImpl();

    /**
     * 增加演出计划
     * @param ischedule
     * @return
     */
    @Override
    public int scheduleInsert(Ischedule ischedule) {
        connection = DBUtils.getConnection();
        int i = -1;
        if(ischeduleDao.isExist2(connection,ischedule)){
            return i;
        }
        i = ischeduleDao.insert(connection,ischedule);
        DBUtils.releaseDB(connection);
        return i;
    }

    /**
     * 根据演出计划ID，修改演出计划
     * @param ischedule
     * @return
     */
    @Override
    public int scheduleUpdate(Ischedule ischedule) {
        connection = DBUtils.getConnection();
        int i = -1;
        if(ischeduleDao.isExist(connection,ischedule)){
            i = ischeduleDao.update(connection,ischedule);
        }
        DBUtils.releaseDB(connection);
        return i;
    }

    /**
     * 根据演出计划ID删除演出计划
     * @param ischedule
     * @return
     */
    @Override
    public int scheduleDelete(Ischedule ischedule) {
        connection = DBUtils.getConnection();
        int i = -1;
        if (ischeduleDao.isExist(connection,ischedule)){
            i = ischeduleDao.delete(connection,ischedule);
        }
        DBUtils.releaseDB(connection);
        return i;
    }

    /**
     * 根据演出计划ID查询演出计划
     * @param ischedule
     * @return
     */
    @Override
    public Ischedule scheduleGet(Ischedule ischedule) {
        connection = DBUtils.getConnection();
        ischedule = ischeduleDao.select(connection,ischedule);
        DBUtils.releaseDB(connection);
        return ischedule;
    }

    /**
     * 根据电影ID，演出厅ID，演出时间查询演出计划
     * @param ischedule
     * @return
     */
    @Override
    public List<Ischedule> scheduleGets(Ischedule ischedule) {
        connection = DBUtils.getConnection();
        List<Ischedule> ischedules = ischeduleDao.gets(connection,ischedule);
        DBUtils.releaseDB(connection);
        return ischedules;
    }

    /**
     * 返回所有的演出计划
     * @return
     */
    @Override
    public List<Ischedule> scheduleGetAll() {
        connection = DBUtils.getConnection();
        List<Ischedule> ischedules = ischeduleDao.getAll(connection);
        DBUtils.releaseDB(connection);
        return ischedules;
    }
}
