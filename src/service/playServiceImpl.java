package service;

import Tools.DBUtils;
import dao.IplayDao;
import dao.playDaoImpl;
import entity.Iplay;

import java.sql.Connection;
import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-25-15:08
 */
public class playServiceImpl implements IplayService {
    Connection connection = null;
    IplayDao iplayDao =new playDaoImpl();

    /**
     * 增加新电影
     * @param iplay
     * @return
     */
    @Override
    public int playInsert(Iplay iplay) {
        connection = DBUtils.getConnection();
        int i = -1;
        if (iplayDao.isExist(connection,iplay)){
            return i;
        }
        i = iplayDao.insert(connection,iplay);
        DBUtils.releaseDB(connection);
        return i;
    }

    /**
     * 修改电影信息
     * @param iplay
     * @return
     */
    @Override
    public int playUpdate(Iplay iplay) {
        connection = DBUtils.getConnection();
        int i= -1;
        if(iplayDao.isExist(connection,iplay)){
            i = iplayDao.update(connection,iplay);
        }
        DBUtils.releaseDB(connection);
        return i;
    }

    /**
     * 根据电影名称查询电影
     * @param iplay
     * @return
     */
    @Override
    public Iplay playGet(Iplay iplay) {
        connection = DBUtils.getConnection();
        iplay = iplayDao.select(connection,iplay);
        DBUtils.releaseDB(connection);
        return iplay;
    }

    /**
     * 返回所有电影信息
     * @return
     */
    @Override
    public List<Iplay> playGetAll() {
        connection = DBUtils.getConnection();
        List<Iplay> iplays = iplayDao.getAll(connection);
        DBUtils.releaseDB(connection);
        return iplays;
    }
}
