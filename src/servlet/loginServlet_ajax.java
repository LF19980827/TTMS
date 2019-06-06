package servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Iemployee;
import entity.ResultInfo;
import org.apache.commons.beanutils.BeanUtils;
import service.IemployeeService;
import service.employeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/loginServlet_ajax")
public class loginServlet_ajax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名和密码操作
        Map<String, String[]> parameterMap = request.getParameterMap();

        Iemployee iemployee = new Iemployee();

        try {
            BeanUtils.populate(iemployee,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //3.调用service查询
        IemployeeService service = new employeeServiceImpl();
        Iemployee iemployee1 = service.login(iemployee);

        ResultInfo info = new ResultInfo();

        //4.判断用户名密码是否错误
        if(iemployee1 == null){
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }else {
            info.setFlag(true);
        }

        //5.响应数据
        ObjectMapper mapper = new ObjectMapper();

        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info); 
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
