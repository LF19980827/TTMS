package entity;

/**
 * @author LFuser
 * @create 2019-05-23-10:44
 * 员工信息
 */
public class Iemployee {
    private int emp_id;             //员工ID
    private String emp_no;          //工号
    private String emp_name;        //姓名
    private String emp_tel_num;     //联系电话
    private String emp_addr;        //住址
    private String emp_email;       //Email
    private String emp_user;        //员工账号
    private String emp_password;    //员工密码
    private int emp_status;         //员工状态


    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_tel_num() {
        return emp_tel_num;
    }

    public void setEmp_tel_num(String emp_tel_num) {
        this.emp_tel_num = emp_tel_num;
    }

    public String getEmp_addr() {
        return emp_addr;
    }

    public void setEmp_addr(String emp_addr) {
        this.emp_addr = emp_addr;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getEmp_user() {
        return emp_user;
    }

    public void setEmp_user(String emp_user) {
        this.emp_user = emp_user;
    }

    public String getEmp_password() {
        return emp_password;
    }

    public void setEmp_password(String emp_password) {
        this.emp_password = emp_password;
    }

    public int getEmp_status() {
        return emp_status;
    }

    public void setEmp_status(int emp_status) {
        this.emp_status = emp_status;
    }

    @Override
    public String toString() {
        return "Iemployee{" +
                "emp_id=" + emp_id +
                ", emp_no='" + emp_no + '\'' +
                ", emp_name='" + emp_name + '\'' +
                ", emp_tel_num='" + emp_tel_num + '\'' +
                ", emp_addr='" + emp_addr + '\'' +
                ", emp_email='" + emp_email + '\'' +
                ", emp_user='" + emp_user + '\'' +
                ", emp_password='" + emp_password + '\'' +
                ", emp_status=" + emp_status +
                '}';
    }

    public Iemployee(String emp_user, String emp_password) {
        this.emp_user = emp_user;
        this.emp_password = emp_password;
    }

    public Iemployee(){

    };
}
