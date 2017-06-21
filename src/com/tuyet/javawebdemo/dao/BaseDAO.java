package com.tuyet.javawebdemo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
public interface BaseDAO extends ShareConnectionManager {
    //phuong thuc them moi su dung PreparedStatement (insert)
    public boolean add(PreparedStatement pre);
    //phuong thuc sua (update)
    public boolean edit(PreparedStatement pre);
    //phuong thuc xoa (delete)
    public boolean del(PreparedStatement pre);
    //phuong thuc thuc hien truy van DB va lay ve ResultSet (select) su dung PreparedStatement
    public ResultSet get(PreparedStatement pre);
    //phuong thuc thuc hien truy van DB va lay ve ResultSet (select) su dung cau lenh sql (String)
    public ResultSet get(String sql);
}