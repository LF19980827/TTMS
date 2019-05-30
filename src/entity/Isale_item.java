package entity;

import java.math.BigInteger;
import java.sql.Date;

/**
 * @author LFuser
 * @create 2019-05-23-12:35
 * 销售单信息
 */
public class Isale_item {
    private BigInteger sale_item_id;    //销售单ID
    private BigInteger ticket_id;       //票ID
    private int customer_id;            //用户ID
    private float sale_item_price;      //售价
    private int sale_status;            //状态
    private int sale_type;              //类别
    private Date sale_time;             //销售时间

    public BigInteger getSale_item_id() {
        return sale_item_id;
    }

    public void setSale_item_id(BigInteger sale_item_id) {
        this.sale_item_id = sale_item_id;
    }

    public BigInteger getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(BigInteger ticket_id) {
        this.ticket_id = ticket_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public float getSale_item_price() {
        return sale_item_price;
    }

    public void setSale_item_price(float sale_item_price) {
        this.sale_item_price = sale_item_price;
    }

    public int getSale_status() {
        return sale_status;
    }

    public void setSale_status(int sale_status) {
        this.sale_status = sale_status;
    }

    public int getSale_type() {
        return sale_type;
    }

    public void setSale_type(int sale_type) {
        this.sale_type = sale_type;
    }

    public Date getSale_time() {
        return sale_time;
    }

    public void setSale_time(Date sale_time) {
        this.sale_time = sale_time;
    }

    @Override
    public String toString() {
        return "Isale_item{" +
                "sale_item_id=" + sale_item_id +
                ", ticket_id=" + ticket_id +
                ", customer_id=" + customer_id +
                ", sale_item_price=" + sale_item_price +
                ", sale_status=" + sale_status +
                ", sale_type=" + sale_type +
                ", sale_time=" + sale_time +
                '}';
    }

}
