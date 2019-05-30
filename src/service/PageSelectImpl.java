package service;

import Tools.DBUtils;
import dao.PageDao;
import dao.PageDaoImpl;
import entity.Istudio;
import entity.PageBean;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class PageSelectImpl<T> implements PageSelect{

    Connection connection = null;
    @Override
    public PageBean<T> findStudioByPage(int currentPage, int rows, Map condition,String table) {
        Connection connection = DBUtils.getConnection();

        PageDao<T> pageDao = new PageDaoImpl();

        PageBean<T> PageBean = new PageBean<T>();

        if(currentPage <= 0){
            currentPage = 1;
        }

        //2.查询总记录数
        int totalCount = pageDao.findByPage(connection, condition,table).size();
        PageBean.setTotalCount(totalCount);

        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        PageBean.setTotalPage(totalPage);

        if(currentPage > totalPage){
            currentPage = totalPage;
        }

        if(currentPage <= 0){
            currentPage = 1;
        }

        //3.设置当前属性，rows属性
        PageBean.setCurrentPage(currentPage);
        PageBean.setRows(rows);

        //4.每页的list集合
        int start = (currentPage - 1)*rows;
        List<T> list = pageDao.findByPage(connection,start,rows,condition,table);
        PageBean.setList(list);

        return PageBean;
    }
}
