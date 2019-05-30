package servlet;//package servlet;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import entity.Istudio;
//import service.IstudioService;
//import service.studioServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/selectAllServlet")
//public class selectAllServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IstudioService studioService = new studioServiceImpl();
//        List<Istudio> studioList = studioService.findAll();
//        ObjectMapper mapper = new ObjectMapper();
//        resp.setContentType("application/json;charset=utf-8");
//        mapper.writeValue(resp.getOutputStream(),studioList);
//        resp.getWriter().write(mapper.writeValueAsString(studioList));
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.doPost(req,resp);
//    }
//}
