package servlet;//package servlet;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import entity.Istudio;
//import entity.PageBean;
//import service.IstudioService;
//import service.PageSelect;
//import service.PageSelectImpl;
//import service.studioServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Map;
//
//@WebServlet("/studioPageServlet")
//public class studioPageServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        String currentPage = request.getParameter("currentPage");
//        String rows = request.getParameter("rows");
//
//        if(currentPage == null || "".equals(currentPage)){
//            currentPage = "1";
//        }
//
//        if(rows == null || "".equals(rows)){
//            rows = "7";
//        }
//
//        Map<String, String[]> condition = request.getParameterMap();
//        //2.调用Service查询PageBean
//        PageSelect<Istudio> service = new PageSelectImpl<>();
//        PageBean<Istudio> pageBean = service.findStudioByPage(Integer.parseInt(currentPage), Integer.parseInt(rows),condition,"studio");
//
//        ObjectMapper mapper = new ObjectMapper();
//        response.setContentType("application/json;charset=utf-8");
//        mapper.writeValue(response.getOutputStream(),pageBean);
//        response.getWriter().write(mapper.writeValueAsString(pageBean));
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
//}
