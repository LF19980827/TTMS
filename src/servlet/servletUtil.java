package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.*;
import org.apache.commons.beanutils.BeanUtils;
import service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


public class servletUtil<T> {


    /**
     * 条件查询演出厅，返回pageBean对象
     * @param request
     * @param table
     * @return
     * @throws UnsupportedEncodingException
     */
    public PageBean<T> Page(HttpServletRequest request, String table) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if(currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }

        if(rows == null || "".equals(rows)){
            rows = "7";
        }
        Map<String, String[]> condition = request.getParameterMap();
        PageSelect<T> service = new PageSelectImpl<>();

        PageBean<T> pageBean = service.findByPage(Integer.parseInt(currentPage), Integer.parseInt(rows),condition,table);
        return pageBean;
    }

    /**
     * 响应请求，返回json数据
     * @param response
     * @param info
     * @throws IOException
     */
    public void back(HttpServletResponse response, ResultInfo info) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
        response.getWriter().write(mapper.writeValueAsString(info));
    }

    public void add(HttpServletRequest request, HttpServletResponse response, String table) throws IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();

        Object object = null;

        int i = 0;

        if(table == "studio"){
            object = new Istudio();
            IstudioService service =  new studioServiceImpl();
            popu(object,map);
            i = service.studioInsert((Istudio) object);
        }else if(table == "employee"){
            object = new Iemployee();
            IemployeeService service = new employeeServiceImpl();
            popu(object,map);
            i = service.employeeInsert((Iemployee) object);
        }else if(table == "play"){
            object = new Iplay();
            IplayService service = new playServiceImpl();
            popu(object,map);
            i = service.playInsert((Iplay) object);
        }else if(table == "schedule"){
            object = new Ischedule();
            IscheduleService service = new scheduleServiceImpl();
            popu(object,map);
            ((Ischedule) object).TraDate();
            i = service.scheduleInsert((Ischedule) object);
        }


        System.out.println(object);
        ResultInfo info = new ResultInfo();
        if (i == 1){
            info.setFlag(true);
            info.setSuccessMsg("添加成功");
        }else {
            info.setFlag(false);
            info.setErrorMsg("添加失败");
        }

        back(response,info);
    }

    private void popu(Object object, Map<String, String[]> map){
        try {
            System.out.println(map);
            BeanUtils.populate(object,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
