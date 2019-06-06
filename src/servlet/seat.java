package servlet;

import entity.PageBean;
import entity.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/seat/*")
public class seat extends BaseServlet {
    protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        servletUtil servletUtil = new servletUtil();
        PageBean pageBean = servletUtil.Page(request, "seat");
        ResultInfo info = new ResultInfo();
        info.setObj(pageBean);
        servletUtil.back(response,info);
    }


}
