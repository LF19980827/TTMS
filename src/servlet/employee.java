package servlet;


import entity.PageBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


@WebServlet("/employee/*")
public class employee extends BaseServlet {
    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException {
        servletUtil servletUtil = new servletUtil();
        PageBean pageBean = servletUtil.Page(request, "employee");
        servletUtil.back(response,pageBean);
    }

}
