package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PageDaoImpl implements PageDao{
    @Override
    public List findByPage(Connection connection, int start, int rows, Map condition, String table) {
        Map<String,String[]> c = condition;
        studioDaoImpl studioDao = new studioDaoImpl();
        String sql = "select * from "+table+" where 1 = 1";
        Set<String> keySet = condition.keySet();
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();
        for (String ks : keySet) {

            if("currentPage".equals(ks) || "rows".equals(ks)){
                continue;
            }

            String value = c.get(ks)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and "+ks+" like ?");
                params.add("%"+value+"%");
            }
        }

        sb.append(" limit ? , ? ");
        params.add(start);
        params.add(rows);

        sql = sb.toString();
        return  studioDao.gets(connection,sql,params.toArray());
    }

    @Override
    public List findByPage(Connection connection, Map condition, String table) {
        Map<String,String[]> c = condition;
        studioDaoImpl studioDao = new studioDaoImpl();
        String sql = "select * from "+table+" where 1 = 1";
        Set<String> keySet = condition.keySet();
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();
        for (String ks : keySet) {

            if("currentPage".equals(ks) || "rows".equals(ks)){
                continue;
            }

            String value = c.get(ks)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and "+ks+" like ?");
                params.add("%"+value+"%");
            }
        }


        sql = sb.toString();
        return  studioDao.gets(connection,sql,params.toArray());
    }
}
