package servlet;


import entity.PageBean;
import entity.ResultInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/studio/*")
public class studio extends BaseServlet {
    protected void select(HttpServletRequest request, HttpServletResponse response) throws IOException {

        servletUtil servletUtil = new servletUtil();
        PageBean pageBean = servletUtil.Page(request, "studio");
        ResultInfo info = new ResultInfo();
        info.setObj(pageBean);
        servletUtil.back(response,info);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        servletUtil util = new servletUtil();
        util.add(req,resp,"studio");
    }
}
