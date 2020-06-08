package com.dodannie.blog.controller;

import com.dodannie.blog.exception.BlogException;
import com.dodannie.blog.utils.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dod_Annie
 * @description
 * @date 2020/6/8 23:01
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value = "/testException/{id}", method = RequestMethod.GET)
    public Result<Object> testException(@PathVariable Integer id) {
        if(id==1){
            return new Result<>();
        } else {
            throw new BlogException("发生了异常！");
        }

    }

}
