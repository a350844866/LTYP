package cn.vworld.mapper;

import cn.vworld.bean.Comment;

import java.util.List;

public interface CommentMapper {
    List<Comment> findCommentsByMovie(String movieInfoId);

    void insertComment(Comment comment);
}
