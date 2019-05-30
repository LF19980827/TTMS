package service;

import entity.Isale_item;

import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-24-9:41
 */
public interface Isale__itemService {
    /**
     * 增加销售单
     * @param isale_item
     * @return
     */
    public int sale_itemInsert(Isale_item isale_item);

    /**
     * 根据销售单ID修改销售单状态
     * @param isale_item
     * @return
     */
    public int sale_itemUpdate(Isale_item isale_item);

    /**
     * 根据销售单ID查询销售单信息
     * @param isale_item
     * @return
     */
    public Isale_item sale_itemGet(Isale_item isale_item);

    /**
     * 返回所有销售单信息
     * @return
     */
    public List<Isale_item> sale_itemGetAll();
}
