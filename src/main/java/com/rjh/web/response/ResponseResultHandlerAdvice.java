package com.rjh.web.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一响应体处理器
 * @author NULL
 * @date 2019-07-16
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@Slf4j
public class ResponseResultHandlerAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        log.info("returnType:"+returnType);
        log.info("converterType:"+converterType);
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 获取响应的状态码
        HttpStatus httpStatus=HttpStatus.resolve(((ServletServerHttpResponse) response).getServletResponse().getStatus());
        // 处理状态码为2XX的响应
        if(httpStatus.is2xxSuccessful()){
            // 判断响应的Content-Type为JSON格式的body
            if(MediaType.APPLICATION_JSON.equals(selectedContentType) || MediaType.APPLICATION_JSON_UTF8.equals(selectedContentType)){
                if(body instanceof ResponseResult){ // 如果响应返回的对象为统一响应体，则直接返回body
                    return body;
                }else{
                    // 只有正常返回的结果才会进入这个判断流程，所以返回正常成功的状态码
                    ResponseResult responseResult =new ResponseResult(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMsg(),body);
                    return responseResult;
                }
            }
        }
        // 非JSON格式body直接返回即可
        return body;
    }
}
