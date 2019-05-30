package dao;



import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PageDaoImpl  implements PageDao{

    StringBuilder sb = new StringBuilder();
    List params = new ArrayList();
    @Override
    public List findByPage(studioDaoImpl studioDao, Connection connection, int start, int rows, Map condition, String table) {

        PageDaoImpl pageDao = new PageDaoImpl();
        loop(condition,table);
        add(start,rows);


        String sql = sb.toString();
        return  studioDao.gets(connection,sql,params.toArray());
    }

    @Override
    public List findByPage(studioDaoImpl studioDao,Connection connection, Map condition, String table) {
        loop(condition,table);


        String sql = sb.toString();
        return  studioDao.gets(connection,sql,params.toArray());
    }

    /**
     * 循环遍历拼接sql语句
     * @param condition
     */
    public void loop(Map condition ,String table){
        Map<String,String[]> c = condition;
        Set<String> keySet = condition.keySet();
        String sql = "select * from "+table+" where 1 = 1";
        sb = new StringBuilder(sql);
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
    }


    @Override
    public List findByPage(employeeDaoImpl employeeDao, Connection connection, int start, int rows, Map condition, String table) {
        loop(condition,table);
        add(start,rows);


        String sql = sb.toString();
        return  employeeDao.gets(connection,sql,params.toArray());
    }

    @Override
    public List findByPage(employeeDaoImpl employeeDao, Connection connection, Map condition, String table) {
        loop(condition,table);


        String sql = sb.toString();
        return  employeeDao.gets(connection,sql,params.toArray());
    }

    @Override
    public List findByPage(playDaoImpl playDao, Connection connection, int start, int rows, Map condition, String table) {
        loop(condition,table);
        add(start,rows);


        String sql = sb.toString();
        return  playDao.gets(connection,sql,params.toArray());
    }

    @Override
    public List findByPage(playDaoImpl playDao, Connection connection, Map condition, String table) {
        loop(condition,table);


        String sql = sb.toString();
        return  playDao.gets(connection,sql,params.toArray());
    }

    @Override
    public List findByPage(scheduleDaoImpl scheduleDao, Connection connection, int start, int rows, Map condition, String table) {
        loop(condition,table);
        add(start,rows);


        String sql = sb.toString();
        return  scheduleDao.gets(connection,sql,params.toArray());
    }

    @Override
    public List findByPage(scheduleDaoImpl scheduleDao, Connection connection, Map condition, String table) {
        loop(condition,table);


        String sql = sb.toString();
        return  scheduleDao.gets(connection,sql,params.toArray());
    }

    @Override
    public List findByPage(seatDaoImpl seatDao, Connection connection, int start, int rows, Map condition, String table) {
        loop(condition,table);
        add(start,rows);


        String sql = sb.toString();
        return  seatDao.gets(connection,sql,params.toArray());
    }

    @Override
    public List findByPage(seatDaoImpl seatDao, Connection connection, Map condition, String table) {
        loop(condition,table);


        String sql = sb.toString();
        return  seatDao.gets(connection,sql,params.toArray());
    }

    @Override
    public void add(int start, int rows) {
        sb.append(" limit ? , ? ");
        params.add(start);
        params.add(rows);
    }

    @Override
    public List judge(Connection connection, String table, Map condition) {
        if(table == "studio"){
            studioDaoImpl dao = new studioDaoImpl();
            return findByPage(dao,connection,(Map<String,String[]>) condition,table);
        }else if(table == "employee"){
            employeeDaoImpl dao = new employeeDaoImpl();
            return findByPage(dao,connection,(Map<String,String[]>) condition,table);
        }else if(table == "play"){
            playDaoImpl dao = new playDaoImpl();
            return findByPage(dao,connection,(Map<String,String[]>) condition,table);
        }else if(table == "schedule"){
            scheduleDaoImpl dao = new scheduleDaoImpl();
            return findByPage(dao,connection,(Map<String,String[]>) condition,table);
        }else if(table == "seat"){
            seatDaoImpl dao = new seatDaoImpl();
            return findByPage(dao,connection,(Map<String,String[]>) condition,table);
        }
        return null;
    }

    @Override
    public List judge(Connection connection,String table, int start, int rows, Map condition) {
        if(table == "studio"){
            studioDaoImpl dao = new studioDaoImpl();
           return findByPage(dao,connection,start,rows,(Map<String,String[]>) condition,table);
        }else if(table == "employee"){
            employeeDaoImpl dao = new employeeDaoImpl();
           return findByPage(dao,connection,start,rows,(Map<String,String[]>) condition,table);
        }else if(table == "play"){
            playDaoImpl dao = new playDaoImpl();
           return findByPage(dao,connection,start,rows,(Map<String,String[]>) condition,table);
        }else if(table == "schedule"){
            scheduleDaoImpl dao = new scheduleDaoImpl();
           return findByPage(dao,connection,start,rows,(Map<String,String[]>) condition,table);
        }else if(table == "seat"){
            seatDaoImpl dao = new seatDaoImpl();
           return findByPage(dao,connection,start,rows,(Map<String,String[]>) condition,table);
        }
        return null;
    }
}
