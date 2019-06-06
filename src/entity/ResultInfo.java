package entity;

import java.io.Serializable;

/**
 * 用于封装后端返回前端数据对象
 */
public class ResultInfo implements Serializable {
    private boolean flag;//后端返回结果正常为true，发生异常返回false
    private Object obj;//后端返回结果数据对象
    private String errorMsg;//发生异常的错误消息
    private String successMsg;

    //无参构造方法
    public ResultInfo() {
    }
    public ResultInfo(boolean flag) {
        this.flag = flag;
    }
    /**
     * 有参构造方法
     * @param flag
     * @param errorMsg
     */
    public ResultInfo(boolean flag, String errorMsg) {
        this.flag = flag;
        this.errorMsg = errorMsg;
    }
    /**
     * 有参构造方法
     * @param flag
     * @param obj
     * @param errorMsg
     */
    public ResultInfo(boolean flag, Object obj, String errorMsg) {
        this.flag = flag;
        this.obj = obj;
        this.errorMsg = errorMsg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setSuccessMsg(String successMsg){
        this.successMsg = successMsg;
    }

    public String getSuccessMsg(){
        return successMsg;
    }

}