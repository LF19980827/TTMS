package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Istudio;
import entity.PageBean;
import service.PageSelect;
import service.PageSelectImpl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class servletUtil<T> {
    public void back(HttpServletResponse response, PageBean pageBean) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),pageBean);
        response.getWriter().write(mapper.writeValueAsString(pageBean));
    }

    public PageBean<T> Page(HttpServletRequest request,String table) throws  UnsupportedEncodingException {
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
}
