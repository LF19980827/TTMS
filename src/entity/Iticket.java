package entity;

import java.math.BigInteger;
import java.sql.Date;

/**
 * @author LFuser
 * @create 2019-05-23-12:56
 * 演出票信息
 */
public class Iticket {
    private BigInteger ticket_id;       //票ID
    private int seat_id;                //座位ID
    private int sched_id;               //计划ID
    private float ticket_price;         //票价
    private int ticket_status;          //状态
    private Date ticket_locked_time;    //加锁时间

    public BigInteger getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(BigInteger ticket_id) {
        this.ticket_id = ticket_id;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public int getSched_id() {
        return sched_id;
    }

    public void setSched_id(int sched_id) {
        this.sched_id = sched_id;
    }

    public float getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(float ticket_price) {
        this.ticket_price = ticket_price;
    }

    public int getTicket_status() {
        return ticket_status;
    }

    public void setTicket_status(int ticket_status) {
        this.ticket_status = ticket_status;
    }

    public Date getTicket_locked_time() {
        return ticket_locked_time;
    }

    public void setTicket_locked_time(Date ticket_locked_time) {
        this.ticket_locked_time = ticket_locked_time;
    }

    @Override
    public String toString() {
        return "Iticket{" +
                "ticket_id=" + ticket_id +
                ", seat_id=" + seat_id +
                ", sched_id=" + sched_id +
                ", ticket_price=" + ticket_price +
                ", ticket_status=" + ticket_status +
                ", ticket_locked_time=" + ticket_locked_time +
                '}';
    }


}
