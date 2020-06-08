package com.dodannie.blog.advice;

import com.dodannie.blog.exception.BlogException;
import com.dodannie.blog.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Dod_Annie
 * @description
 * @date 2020/5/30 12:47
 */
@ControllerAdvice
@Slf4j
public class BlogExceptionAdvice {
    /**
     * 统一处理 BlogException
     *
     * @param exception
     */
    @ExceptionHandler(BlogException.class)
    @ResponseBody
    public Result<Object> exceptionHandler(BlogException exception) {
        log.error("统一异常处理：", exception);
        return new Result<>(exception.getErrorCode(), exception.getMessage());
    }
}
