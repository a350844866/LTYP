package cn.vworld.service.impl;

import cn.vworld.mapper.CommentMapper;
import cn.vworld.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiaxu
 * @version $Id: ${FILE_NAME}, v 0.1 2018/1/31 10:57 jiaxu Exp $$
 */
@Service
public class CommentServiceimpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public int getCommentCount() {
        return commentMapper.selectCommentCount();
    }

    @Override
    public int getRecentCommentCount() {
        return commentMapper.selectRecentCommentCount();
    }
}
