package service;

import entity.Isale;

import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-24-9:41
 */
public interface IsaleService {
    /**
     * 增加销售单
     * @param isale
     * @return
     */
    public int saleInsert(Isale isale);

    /**
     * 根据销售单ID修改销售单状态
     * @param isale
     * @return
     */
    public int saleUpdate(Isale isale);

    /**
     * 根据销售单ID查询销售单信息
     * @param isale
     * @return
     */
    public Isale saleGet(Isale isale);

    /**
     * 返回所有销售单信息
     * @return
     */
    public List<Isale> saleGetAll();
}
