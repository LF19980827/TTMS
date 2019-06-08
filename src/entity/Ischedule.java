package entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author LFuser
 * @create 2019-05-23-12:51
 * 放映计划
 */
public class Ischedule {
    private int sched_id;               //计划ID
    private int studio_id;              //演出厅ID
    private int play_id;                //电影ID
    private String sched_time_String;   //演出时间
    private double sched_ticket_price;  //票价
    private int sched_status;           //状态
    private Timestamp sched_time;

    public int getSched_id() {
        return sched_id;
    }

    public void setSched_id(int sched_id) {
        this.sched_id = sched_id;
    }

    public int getStudio_id() {
        return studio_id;
    }

    public void setStudio_id(int studio_id) {
        this.studio_id = studio_id;
    }

    public int getPlay_id() {
        return play_id;
    }

    public void setPlay_id(int play_id) {
        this.play_id = play_id;
    }

    public String getSched_time_String() {
        return sched_time_String;
    }

    public void setSched_time_String(String sched_time_String) {
        this.sched_time_String = sched_time_String;
    }

    public Date getSched_time() {
        return sched_time;
    }

    public void setSched_time(Timestamp sched_time) {
        this.sched_time = sched_time;
    }

    public double getSched_ticket_price() {
        return sched_ticket_price;
    }

    public void setSched_ticket_price(double sched_ticket_price) {
        this.sched_ticket_price = sched_ticket_price;
    }

    public int getSched_status() {
        return sched_status;
    }

    public void setSched_status(int sched_status) {
        this.sched_status = sched_status;
    }

    public  void TraDate(){
        try {
            sched_time =  Timestamp.valueOf(sched_time_String);
        } catch (Exception e) {
            System.out.println("时间字符串格式有误");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Ischedule{" +
                "sched_id=" + sched_id +
                ", studio_id=" + studio_id +
                ", play_id=" + play_id +
                ", sched_time_String='" + sched_time_String + '\'' +
                ", sched_ticket_price=" + sched_ticket_price +
                ", sched_status=" + sched_status +
                ", sched_time=" + sched_time +
                '}';
    }
}
