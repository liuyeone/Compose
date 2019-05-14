package com.example.common.handle;

import com.example.common.exception.CustomException;
import com.example.common.util.AjaxResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局捕获异常和自定义全局捕获异常
 */
@ControllerAdvice
public class MyControllerAdvice {

    @ResponseBody
    @ExceptionHandler(value = CustomException.class)
    public AjaxResult customExceptionHandler(CustomException e) {
        AjaxResult result = new AjaxResult();
        result.setSuccess(false);
        result.setErrorMsg(e.getMethod() + ":" + e.getMessage());
        result.setData(e.getDescInfo());
        return result;
    }

    /**
     * 全局异常处理，反正异常返回统一格式的AjaxResult
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public AjaxResult exceptionHandler(Exception e) {
        AjaxResult result = new AjaxResult();
        result.setSuccess(false);
        result.setErrorMsg(e.getMessage());
        return result;
    }
}
