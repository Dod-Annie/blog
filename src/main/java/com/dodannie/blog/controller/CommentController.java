package com.dodannie.blog.controller;

import com.dodannie.blog.enums.ResultEnum;
import com.dodannie.blog.pojo.Comment;
import com.dodannie.blog.pojo.CommentGoods;
import com.dodannie.blog.pojo.User;
import com.dodannie.blog.service.CommentService;
import com.dodannie.blog.utils.Page;
import com.dodannie.blog.utils.Result;
import com.dodannie.blog.utils.ShiroUtils;
import com.dodannie.blog.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author Dod_Annie
 * @description
 * @date 2020/6/30 14:21
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 保存
     *
     * @param comment
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Object> save(@RequestBody Comment comment) {
        User user = (User) ShiroUtils.getLoginUser();
        comment.setCommentUser(user.getUserId());
        if (StringUtils.isBlank(comment.getCommentBlog())) {
            return new Result<>(ResultEnum.PARAMS_NULL.getCode(), "博客id不能为空！");
        }
        commentService.save(comment);
        return new Result<>("评论成功！");
    }

    /**
     * 查询当前博客的评论
     *
     * @param blogId
     * @return
     */
    @RequestMapping(value = "/getByBlog/{blogId}", method = RequestMethod.GET)
    public Result<List<Comment>> getByBlog(@PathVariable String blogId) {
        List<Comment> comments = commentService.getByBlog(blogId);
        return new Result<>(comments);
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    public Result<Object> deleteById(@PathVariable String id) {
        commentService.deleteById(id);
        return new Result<>("删除成功！");
    }

    /**
     * 点赞
     *
     * @param commentGoods
     * @return
     */
    @RequestMapping(value = "/good", method = RequestMethod.POST)
    public Result<Object> good(@RequestBody CommentGoods commentGoods) {
        if (StringUtils.isBlank(commentGoods.getCommentId())) {
            return new Result<>("评论id不能为空！");
        }
        commentService.goodByCommentIdAndUser(commentGoods);
        return new Result<>("点赞成功！");
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public Result<Page<Comment>> getList(@RequestBody Page<Comment> page) {
        page = commentService.getByPage(page);
        return new Result<>(page);
    }

    /**
     * 后台分页查询
     * @param page
     * @return
     */
    @RequestMapping(value = "/getByPage", method = RequestMethod.POST)
    public Result<Page<Comment>> getByPage(@RequestBody Page<Comment> page) {
        page = commentService.getByPageBack(page);
        return new Result<>(page);
    }

}
