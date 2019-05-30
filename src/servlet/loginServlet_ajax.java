package servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Iemployee;
import entity.ResultInfo;
import service.IstudioService;
import service.employeeServiceImpl;
import service.studioServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/loginServlet_ajax")
public class loginServlet_ajax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名和密码操作
        String user = request.getParameter("user");
        String password = request.getParameter("password");


        Iemployee iemployee = new Iemployee(user,password);

        //3.调用service查询
        employeeServiceImpl service = new employeeServiceImpl();
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
