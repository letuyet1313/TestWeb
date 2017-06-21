package com.tuyet.javawebdemo.service;

import java.util.List;

import com.tuyet.javawebdemo.model.Post;
import com.tuyet.javawebdemo.transfer.PostTranfer;
import com.tuyet.javawebdemo.utils.ConnectionPool;
public class PostServiceImpl implements PostService {
    private PostTranfer postTranfer;
    public PostServiceImpl(ConnectionPool cp) {
        this.postTranfer = new PostTranfer(cp);
    }
    /***************/
    public ConnectionPool getConnectionPool() {
        return this.postTranfer.getConnectionPool();
    }
    public void releaseConnection() {
        this.postTranfer.releaseConnection();
    }
    public void refreshConnectionPool() {
        this.postTranfer.refreshConnectionPool();
    }
    /***************/
    public boolean addPost(Post post) {
        boolean bl = postTranfer.addPost(post);
        this.postTranfer.refreshConnectionPool();
        return bl;
    }
    public boolean editPost(Post post) {
        boolean bl = postTranfer.editPost(post);
        this.postTranfer.refreshConnectionPool();
        return bl;
    }
    public boolean delPost(Post post) {
        boolean bl = postTranfer.delPost(post);
        this.postTranfer.refreshConnectionPool();
        return bl;
    }
    public List<Post> findAll() {
        List<Post> list = this.postTranfer.findAll();
        this.postTranfer.releaseConnection();
        return list;
    }
    public List<Post> find(int start, int limit) {
        List<Post> list = this.postTranfer.find(start, limit);
        this.postTranfer.releaseConnection();
        return list;
    }
    public Post findById(int id) {
        Post p = this.postTranfer.findById(id);
        this.postTranfer.releaseConnection();
        return p;
    }
    public Post findBySlug(String slug) {
        Post p = this.postTranfer.findBySlug(slug);
        this.postTranfer.releaseConnection();
        return p;
    }
}