package cn.vworld.service;

/**
 * @author jiaxu
 * @version $Id: ${FILE_NAME}, v 0.1 2018/1/31 10:56 jiaxu Exp $$
 */
public interface CommentService {
    /**
     * 查询评论总数
     *
     * @return
     */
    int getCommentCount();

    /**
     * 查询最近更新的评论数量
     * @return
     */
    int getRecentCommentCount();
}
