package servlet;

import entity.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/schedule/*")
public class schedule extends BaseServlet {
    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        servletUtil servletUtil = new servletUtil();
        PageBean pageBean = servletUtil.Page(request, "schedule");
        servletUtil.back(response,pageBean);
    }

}
