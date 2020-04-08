package com.hp.docker_base.controller.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object defaultErrorHandler(HttpServletRequest req, Exception e) {

        System.out.println("###出现异常！");
        Map<String,Object> map=new HashMap<>();
        map.put("url",req.getRequestURL().toString());
        map.put("msg",e.getMessage());
        return map;
    }

}