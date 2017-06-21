package com.tuyet.javawebdemo.service;

import java.util.List;

import com.tuyet.javawebdemo.model.Post;
public interface PostService extends BaseService{
    // Them moi post
    public boolean addPost(Post post);
    // Sua post
    public boolean editPost(Post post);
    // Xoa post
    public boolean delPost(Post post);
    // Lay danh sach post
    public List<Post> findAll();
    // Lay danh sach post theo phan trang
    public List<Post> find(int start, int limit);
    // lay post theo id
    public Post findById(int id);
    // lay post theo duong dan slug
    public Post findBySlug(String slug);
    
    public static void main(String [] args){
        PostService ps = new PostServiceImpl(null);
        List<Post> plist = ps.findAll();
        if(plist!=null){
            for(Post p : plist){
                System.out.println(p.getPostName());
            }
        }else{
            System.out.println("Không có dữ liệu!");
        }
    }
}