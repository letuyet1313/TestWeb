package com.tuyet.javawebdemo.dao;

import java.sql.ResultSet;

import com.tuyet.javawebdemo.model.Post;
public interface PostDAO extends BaseDAO{
    //Them moi post
    public boolean addPost(Post post);
    //Sua post
    public boolean editPost(Post post);
    //Xoa post
    public boolean delPost(Post post);
    //Lay danh sach post
    public ResultSet findAll();
    //Lay danh sach post theo phan trang
    public ResultSet find(int start, int limit);
    //lay post theo id
    public ResultSet findById(int id);
    //lay post theo duong dan slug
    public ResultSet findBySlug(String slug);
}
