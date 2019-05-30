package service;

import entity.Ischedule;

import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-24-9:41
 */
public interface IscheduleService {

    /**
     * 增加演出计划
     * @param ischedule
     * @return
     */
    public int scheduleInsert(Ischedule ischedule);

    /**
     * 修改演出计划
     * @param ischedule
     * @return
     */
    public int scheduleUpdate(Ischedule ischedule);

    /**
     * 删除演出计划
     * @param ischedule
     * @return
     */
    public int scheduleDelete(Ischedule ischedule);

    /**
     * 根据演出计划ID查询演出计划
     * @param ischedule
     * @return
     */
    public Ischedule scheduleGet(Ischedule ischedule);

    /**
     * 根据电影ID（必选），演出厅ID，演出时间查询演出计划
     * @param ischedule
     * @return
     */
    public List<Ischedule> scheduleGets(Ischedule ischedule);

    /**
     * 查询所有演出计划
     * @return
     */
    public List<Ischedule> scheduleGetAll();

}
