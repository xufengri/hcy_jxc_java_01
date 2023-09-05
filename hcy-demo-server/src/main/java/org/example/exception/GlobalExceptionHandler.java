package org.example.exception;


import lombok.extern.slf4j.Slf4j;
import org.example.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author Lenovo
 * @Date 2023/5/24 10:21
 * @Version 1.0
 **/
//全局异常处理类
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    //预期异常（业务异常） BusinessException
    @ExceptionHandler(BusinessException.class)
    public Result handlerBusinessException(BusinessException e) {
        log.error("出现了业务异常：{}", e);
        return Result.error(e.getCode(), e.getMessage());
    }

    //非预期异常 Exception 兜底异常处理
    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e) {
        log.error("出现了未知异常：{}", e);
        return Result.error(500,"未知异常，请稍后重试");
    }
}
