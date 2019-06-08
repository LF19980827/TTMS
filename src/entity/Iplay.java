package entity;

import java.util.Date;

/**
 * @author LFuser
 * @create 2019-05-23-12:12
 * 电影信息
 */
public class Iplay {
    private int play_id;                //电影ID
    private int play_type_id;           //电影类型ID
    private int play_lang_id;           //电影语言ID
    private String play_name;           //电影名称
    private String play_introduction;   //剧情简介
    private int play_length;            //演出时长
    private double play_ticket_price;    //基准票价
    private int play_status;            //电影状态          （0--待上映  1--上映中  2-已下映）


    public int getPlay_id() {
        return play_id;
    }

    public void setPlay_id(int play_id) {
        this.play_id = play_id;
    }

    public int getPlay_type_id() {
        return play_type_id;
    }

    public void setPlay_type_id(int play_type_id) {
        this.play_type_id = play_type_id;
    }

    public int getPlay_lang_id() {
        return play_lang_id;
    }

    public void setPlay_lang_id(int play_lang_id) {
        this.play_lang_id = play_lang_id;
    }

    public String getPlay_name() {
        return play_name;
    }

    public void setPlay_name(String play_name) {
        this.play_name = play_name;
    }

    public String getPlay_introduction() {
        return play_introduction;
    }

    public void setPlay_introduction(String play_introduction) {
        this.play_introduction = play_introduction;
    }

    public int getPlay_length() {
        return play_length;
    }

    public void setPlay_length(int play_length) {
        this.play_length = play_length;
    }

    public double getPlay_ticket_price() {
        return play_ticket_price;
    }

    public void setPlay_ticket_price(double play_ticket_price) {
        this.play_ticket_price = play_ticket_price;
    }

    public int getPlay_status() {
        return play_status;
    }

    public void setPlay_status(int play_status) {
        this.play_status = play_status;
    }
}
