package com.tuyet.javawebdemo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tuyet.javawebdemo.model.Post;
import com.tuyet.javawebdemo.utils.ConnectionPool;
public class PostDAOImpl extends BaseDAOImpl implements PostDAO {
    public PostDAOImpl(ConnectionPool cp) {
        super(cp);
    }
    public boolean addPost(Post post) {
        try {
            String sql = "INSERT INTO posts("
                    + " Post_Name, Cate_ID, User_ID, Post_Content, "
                    + " Post_Slug, Publish_Date, Last_Edit, "
                    + " Image, Num_Views, Status) "
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setString(1, post.getPostName());
            pre.setInt(2, post.getCategory().getCateId());
            pre.setInt(3, post.getUser().getUserId());
            pre.setString(4, post.getPostContent());
            pre.setString(5, post.getPostSlug());
            pre.setDate(6, new java.sql.Date(post.getPublishDate().getTime()));
            pre.setDate(7, new java.sql.Date(post.getLastEdit().getTime()));
            pre.setString(8, post.getImage());
            pre.setInt(9, 0);
            pre.setInt(10, post.getStatus());
            return this.add(pre);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public boolean editPost(Post post) {
        try {
            String sql = "UPDATE posts SET Post_Name=?, Cate_ID=?, User_ID=?, "
                    + " Post_Content=?, Post_Slug=?, Publish_Date=?, Last_Edit=?, "
                    + " Image=?, Num_Views=?, Status=? WHERE Post_ID = ?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setString(1, post.getPostName());
            pre.setInt(2, post.getCategory().getCateId());
            pre.setInt(3, post.getUser().getUserId());
            pre.setString(4, post.getPostContent());
            pre.setString(5, post.getPostSlug());
            pre.setDate(6, new java.sql.Date(post.getPublishDate().getTime()));
            pre.setDate(7, new java.sql.Date(post.getLastEdit().getTime()));
            pre.setString(8, post.getImage());
            pre.setInt(9, 0);
            pre.setInt(10, post.getStatus());
            pre.setInt(11, post.getPostId());
            return this.edit(pre);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean delPost(Post post) {
        try {
            String sql = "DELETE FROM posts WHERE Post_ID = ?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setInt(1, post.getPostId());
            this.del(pre);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //Hàm lấy tất cả dữ liệu bao gồm cả thông tin của user tương ứng.
    public ResultSet findAll() {
        String sql = "SELECT * FROM posts inner join categories using(Cate_ID) inner join users using(User_ID)";
        return this.get(sql);
    }
    //tương tự hàm findAll nhưng có thêm giới hạn dữ liệu lấy ra(dùng để phân trang)
    public ResultSet find(int start, int limit) {
        try {
            String sql = "SELECT * FROM posts inner join categories using(Cate_ID) inner join users using(User_ID)  LIMIT ?, ?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setInt(1, start);
            pre.setInt(2, limit);
            return this.get(pre);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //Hàm lấy post theo id bao gồm cả thông tin của user tương ứng.
    public ResultSet findById(int id) {
        try {
            String sql = "SELECT * FROM posts inner join categories using(Cate_ID) inner join users using(User_ID) WHERE Post_ID = ?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setInt(1, id);
            return this.get(pre);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //Hàm lấy post theo slug(đường dẫn) bao gồm cả thông tin của user tương ứng.
    public ResultSet findBySlug(String slug) {
        try {
            String sql = "SELECT * FROM posts inner join categories using(Cate_ID) inner join users using(User_ID) WHERE Post_Slug = ?";
            PreparedStatement pre = this.connection.prepareStatement(sql);
            pre.setString(1, slug);
            return this.get(pre);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
