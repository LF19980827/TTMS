package dao;



import java.sql.Connection;

import java.util.List;
import java.util.Map;

public interface PageDao<T> {
    public List<T> findByPage(Connection connection, int start, int rows, Map<String,String[]> condition,String table);
    public List<T> findByPage(Connection connection, Map<String,String[]> condition,String table);
}
