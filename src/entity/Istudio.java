package entity;

/**
 * @author LFuser
 * @create 2019-05-23-9:31
 * 演出厅信息
 */
public class Istudio {
    private int studio_id;              //演出厅ID
    private String studio_name;         //名称
    private int studio_row_count;       //行数
    private int studio_col_count;       //列数
    private String studio_introduction; //简介

    public int getStudio_id() {
        return studio_id;
    }

    public void setStudio_id(int studio_id) {
        this.studio_id = studio_id;
    }

    public String getStudio_name() {
        return studio_name;
    }

    public void setStudio_name(String studio_name) {
        this.studio_name = studio_name;
    }

    public int getStudio_row_count() {
        return studio_row_count;
    }

    public void setStudio_row_count(int studio_row_count) {
        this.studio_row_count = studio_row_count;
    }

    public int getStudio_col_count() {
        return studio_col_count;
    }

    public void setStudio_col_count(int studio_col_count) {
        this.studio_col_count = studio_col_count;
    }

    public String getStudio_introduction() {
        return studio_introduction;
    }

    public void setStudio_introduction(String studio_introduction) {
        this.studio_introduction = studio_introduction;
    }

    @Override
    public String toString() {
        return "Istudio{" +
                "studio_id=" + studio_id +
                ", studio_name='" + studio_name + '\'' +
                ", studio_row_count=" + studio_row_count +
                ", studio_col_count=" + studio_col_count +
                ", studio_introduction='" + studio_introduction + '\'' +
                '}';
    }


}
