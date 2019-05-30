package service;

import entity.Iplay;

import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-24-9:40
 */
public interface IplayService {
    /**
     * 增加新电影
     * @param iplay
     * @return
     */
    public int playInsert(Iplay iplay);

    /**
     * 修改电影信息
     * @param iplay
     * @return
     */
    public int playUpdate(Iplay iplay);

    /**
     * 根据电影名称查询电影
     * @param iplay
     * @return
     */
    public Iplay playGet(Iplay iplay);

    /**
     * 返回所有电影
     * @return
     */
    public List<Iplay> playGetAll();
}
