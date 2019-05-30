package entity;

/**
 * @author LFuser
 * @create 2019-05-23-11:28
 * 用户信息
 */
public class Icustomer {
    private int customer_id;            //用户ID
    private String customer_user;       //用户账号
    private String customer_password;   //用户密码
    private String customer_email;      //用户邮箱
    private float customer_money;       //用户余额
    private String customer_tel;        //用户电话
    private String customer_name;       //用户姓名

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_user() {
        return customer_user;
    }

    public void setCustomer_user(String customer_user) {
        this.customer_user = customer_user;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public float getCustomer_money() {
        return customer_money;
    }

    public void setCustomer_money(float customer_money) {
        this.customer_money = customer_money;
    }

    public String getCustomer_tel() {
        return customer_tel;
    }

    public void setCustomer_tel(String customer_tel) {
        this.customer_tel = customer_tel;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Icustomer(String customer_user, String customer_password) {
        this.customer_user = customer_user;
        this.customer_password = customer_password;
    }

    public Icustomer(){

    }

    @Override
    public String toString() {
        return "Icustomer{" +
                "customer_id=" + customer_id +
                ", customer_user='" + customer_user + '\'' +
                ", customer_password='" + customer_password + '\'' +
                ", customer_email='" + customer_email + '\'' +
                ", customer_money=" + customer_money +
                ", customer_tel='" + customer_tel + '\'' +
                ", customer_name='" + customer_name + '\'' +
                '}';
    }
}
