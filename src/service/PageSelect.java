package service;

import entity.PageBean;

import java.util.Map;

public interface PageSelect<T> {
    public PageBean<T> findStudioByPage(int currentPage, int rows, Map<String, String[]> condition,String table);
}
