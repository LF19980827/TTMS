package entity;

import java.sql.Date;

/**
 * @author LFuser
 * @create 2019-05-23-12:51
 * 放映计划
 */
public class Ischedule {
    private int sched_id;               //计划ID
    private int studio_id;              //演出厅ID
    private int play_id;                //电影ID
    private Date sched_time;            //演出时间
    private float sched_ticket_price;   //票价

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

    public Date getSched_time() {
        return sched_time;
    }

    public void setSched_time(Date sched_time) {
        this.sched_time = sched_time;
    }

    public float getSched_ticket_price() {
        return sched_ticket_price;
    }

    public void setSched_ticket_price(float sched_ticket_price) {
        this.sched_ticket_price = sched_ticket_price;
    }

    @Override
    public String toString() {
        return "Ischedule{" +
                "sched_id=" + sched_id +
                ", studio_id=" + studio_id +
                ", play_id=" + play_id +
                ", sched_time=" + sched_time +
                ", sched_ticket_price=" + sched_ticket_price +
                '}';
    }


}
