package com.tuyet.javawebdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tuyet.javawebdemo.utils.ConnectionPool;
import com.tuyet.javawebdemo.utils.ConnectionPoolImpl;
public class BaseDAOImpl implements BaseDAO {
    private ConnectionPool connectionPool;
    protected Connection connection;
    // Contructor co tham so truyen vao la doi tuong ConnectionPool
    public BaseDAOImpl(ConnectionPool cp) {
        // neu ConnectionPool truyen vao la null thi tao moi
        if (cp == null) {
            this.connectionPool = new ConnectionPoolImpl();
        } else {
            this.connectionPool = cp;
        }
        // Lay ket noi tu ConnectionPool
        try {
            this.connection = connectionPool.getConnection();
            // Set AutoCommit la false de thuc hien commit bang tay
            if (this.connection.getAutoCommit()) {
                this.connection.setAutoCommit(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }
    public void releaseConnection() {
        try {
            this.connectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void refreshConnectionPool() {
        this.connectionPool.refreshConnectionPool();
    }
    public boolean executeUpdate(PreparedStatement pre) {
        if (pre != null) {
            try {
                int numRow = pre.executeUpdate();
                if (numRow == 0) {
                    this.connection.rollback();
                } else {
                    this.connection.commit();
                    return true;
                }
            } catch (SQLException e) {
                try {
                    this.connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
            return false;
        }
        return false;
    }
    @Override
    public boolean add(PreparedStatement pre) {
        return executeUpdate(pre);
    }
    @Override
    public boolean edit(PreparedStatement pre) {
        return executeUpdate(pre);
    }
    @Override
    public boolean del(PreparedStatement pre) {
        return executeUpdate(pre);
    }
    @Override
    public ResultSet get(PreparedStatement pre) {
        try {
            return pre.executeQuery();
        } catch (SQLException e) {
            try {
                this.connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public ResultSet get(String sql) {
        try {
            PreparedStatement pre = this.connection.prepareStatement(sql);
            return this.get(pre);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
