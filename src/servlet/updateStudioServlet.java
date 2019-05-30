package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Istudio;
import entity.ResultInfo;
import org.apache.commons.beanutils.BeanUtils;
import service.IstudioService;
import service.studioServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LFuser
 * @create 2019-05-30-9:25
 */
public class updateStudioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IstudioService studioService = new studioServiceImpl();
        Istudio istudio = new Istudio();
        Map<String,String[]> map = req.getParameterMap();

        try {
            BeanUtils.populate(istudio,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        int i = studioService.studioUpdate(istudio);

        ResultInfo info = new ResultInfo();
        if (i>=1){
            info.setFlag(true);
            info.setErrorMsg("添加成功");
        }else {
            info.setFlag(false);
            info.setErrorMsg("添加失败");
        }

        resp.setContentType("application/json;charset=utf-8");

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(),info);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
