package entity;

/**
 * @author LFuser
 * @create 2019-05-23-11:33
 * 数据字典
 */
public class Idata_dict {
    private int dict_id;           //字典ID
    private int dict_parent_id;    //所属字典ID
    private int dict_index;        //字典序号
    private String dict_name;      //字典名称
    private String dict_value;    //字典值

    public int getDict_id() {
        return dict_id;
    }

    public void setDict_id(int dict_id) {
        this.dict_id = dict_id;
    }

    public int getDict_parent_id() {
        return dict_parent_id;
    }

    public void setDict_parent_id(int dict_parent_id) {
        this.dict_parent_id = dict_parent_id;
    }

    public int getDict_index() {
        return dict_index;
    }

    public void setDict_index(int dict_index) {
        this.dict_index = dict_index;
    }

    public String getDict_name() {
        return dict_name;
    }

    public void setDict_name(String dict_name) {
        this.dict_name = dict_name;
    }

    public String getDict_values() {
        return dict_value;
    }

    public void setDict_values(String dict_values) {
        this.dict_value = dict_values;
    }

}
