package service;

import entity.Icustomer;

/**
 * @author LFuser
 * @create 2019-05-24-9:39
 */
public interface IcustomerService {
    /**
     * 顾客登陆
     * @param icustomer
     * @return
     */
    public Icustomer login(Icustomer icustomer);

    /**
     * 顾客注册
     * @param icustomer
     * @return
     */
    public int customerInsert(Icustomer icustomer);

    /**
     * 修改顾客信息
     * @param icustomer
     * @return
     */
    public int customerUpdate(Icustomer icustomer);


}
