package service;

import entity.Iemployee;

import java.util.List;

/**
 * @author LFuser
 * @create 2019-05-24-9:40
 */
public interface IemployeeService {

    /**
     * 员工登陆验证
     * @param iemployee
     * @return
     */
    public Iemployee login(Iemployee iemployee);

    /**
     * 增加新员工信息
     * @param iemployee
     * @return
     */
    public int employeeInsert(Iemployee iemployee);

    /**
     * 修改员工信息
     * @param iemployee
     * @return
     */
    public int employeeUpdate(Iemployee iemployee);

    /**
     * 删除员工
     * @param iemployee
     * @return
     */
    public int employeeDelete(Iemployee iemployee);

    /**
     * 查询员工信息
     * @param iemployee
     * @return
     */
    public Iemployee employeeGet(Iemployee iemployee);

    /**
     * 返回所有员工信息
     * @return
     */
    public List<Iemployee> employeeGets();
}
