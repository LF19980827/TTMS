package service;


import entity.Iemployee;
import entity.Istudio;
import entity.PageBean;

import java.util.List;
import java.util.Map;

public interface IstudioService {
    /**
     * 查询所有演出厅
     * @return
     */
    public List<Istudio> findAll();

    /**
     * 添加新演出厅
     * @param istudio
     * @return
     */
    public int studioInsert(Istudio istudio);

    /**
     * 查询演出厅
     * @param istudio
     * @return
     */
    public List<Istudio> studioGet(Istudio istudio);

}
