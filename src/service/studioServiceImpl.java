package service;

import Tools.DBUtils;
import dao.*;
import entity.Iemployee;
import entity.Iseat;
import entity.Istudio;

import java.sql.Connection;
import java.util.List;

public class studioServiceImpl implements IstudioService {

    Connection connection = null;
    IstudioDao istudioDao = new studioDaoImpl();

    /**
     * 返回所有演出厅信息
     * @return
     */
    @Override
    public List<Istudio> findAll() {
        connection = DBUtils.getConnection();
        List<Istudio> studioList = istudioDao.getAll(connection);
        DBUtils.releaseDB(connection);
        return studioList;
    }

    /**
     * 增加演出厅
     * @param istudio
     * @return
     */
    @Override
    public int studioInsert(Istudio istudio) {
        connection = DBUtils.getConnection();
        int i = -1;
        if(istudioDao.isExist(connection,istudio)){   //如果演出厅名称存在则返回失败-1
            return i;
        }else{
            i = istudioDao.insert(connection,istudio);   //如果演出厅名称不存在则添加演出厅
            }
        DBUtils.releaseDB(connection);
        return i;
    }

    /**
     * 根据演出厅名称查询演出厅
     * @param istudio
     * @return
     */
    @Override
    public List<Istudio> studioGet(Istudio istudio) {
        connection = DBUtils.getConnection();
        List<Istudio> istudios = istudioDao.select(connection,istudio);
        DBUtils.releaseDB(connection);
        return istudios;
    }

    @Override
    public int studioUpdate(Istudio istudio) {
        connection = DBUtils.getConnection();
        int i = -1;
        if (istudioDao.isExist(connection,istudio)){
            i = istudioDao.update(connection,istudio);
        }
        return i;
    }


}
