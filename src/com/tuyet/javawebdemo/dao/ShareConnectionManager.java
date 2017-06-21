package com.tuyet.javawebdemo.dao;

import com.tuyet.javawebdemo.utils.ConnectionPool;

public interface ShareConnectionManager {
    //get bo quan ly ket noi
    public ConnectionPool getConnectionPool();
    // Tra lai ket noi
    public void releaseConnection();
    // Lam moi ConnectionPool
    public void refreshConnectionPool();
}
