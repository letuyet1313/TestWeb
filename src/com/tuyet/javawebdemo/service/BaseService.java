package com.tuyet.javawebdemo.service;

import com.tuyet.javawebdemo.utils.ConnectionPool;

public interface BaseService {
    public ConnectionPool getConnectionPool();
    public void releaseConnection();
    public void refreshConnectionPool();
}