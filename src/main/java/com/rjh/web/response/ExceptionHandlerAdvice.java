package com.rjh.web.response;

import com.rjh.web.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 异常处理器
 * @author NULL
 * @since  2019-07-16
 */
@Slf4j
@ControllerAdvice(basePackages = "com.rjh.web.controller")
public class ExceptionHandlerAdvice {
    /**
     * 处理未捕获的RuntimeException
     * @param e 运行时异常
     * @return 统一响应体
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult handleRuntimeException(RuntimeException e){
        log.error(e.getMessage(),e);
        return new ResponseResult(ResponseCode.SERVICE_ERROR.getCode(),ResponseCode.SERVICE_ERROR.getMsg(),null);
    }
    /**
     * 处理业务异常BaseException
     * @param e 业务异常
     * @return 统一响应体
     */
    @ExceptionHandler(BaseException.class)
    public ResponseResult handleBaseException(BaseException e){
        log.error(e.getMessage(),e);
        ResponseCode code=e.getCode();
        return new ResponseResult(code.getCode(),code.getMsg(),null);
    }
}
