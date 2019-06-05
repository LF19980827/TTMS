package dao;



import java.sql.Connection;

import java.util.List;
import java.util.Map;

public interface PageDao<T> {
    public List<T> findByPage(studioDaoImpl studioDao,Connection connection, int start, int rows, Map<String,String[]> condition,String table);
    public List<T> findByPage(studioDaoImpl studioDao,Connection connection, Map<String,String[]> condition,String table);
    public List<T> findByPage(employeeDaoImpl employeeDao,Connection connection, int start, int rows, Map<String,String[]> condition,String table);
    public List<T> findByPage(employeeDaoImpl employeeDao,Connection connection, Map<String,String[]> condition,String table);
    public List<T> findByPage(playDaoImpl playDao,Connection connection, int start, int rows, Map<String,String[]> condition,String table);
    public List<T> findByPage(playDaoImpl playDao,Connection connection, Map<String,String[]> condition,String table);
    public List<T> findByPage(scheduleDaoImpl scheduleDao,Connection connection, int start, int rows, Map<String,String[]> condition,String table);
    public List<T> findByPage(scheduleDaoImpl scheduleDao,Connection connection, Map<String,String[]> condition,String table);
    public List<T> findByPage(seatDaoImpl seatDao,Connection connection, int start, int rows, Map<String,String[]> condition,String table);
    public List<T> findByPage(seatDaoImpl seatDao,Connection connection, Map<String,String[]> condition,String table);
    public void loop(Map<String,String[]> condition,String table);
    public void add(int start,int rows);
    public List<T> judge(Connection connection,String table,int start, int rows, Map<String,String[]> condition);
    public List<T> judge(Connection connection,String table, Map<String,String[]> condition);
}
