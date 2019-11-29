package com.zx.hls.controller;

import com.zx.hls.exception.HttpResult;
import com.zx.hls.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    /**
     * 登录校验
     * @param userName
     * @param pass
     * @param validCode
     */
    @RequestMapping(value="login")
    public HttpResult Login(String userName,String pass,String validCode){

        HttpResult result=loginService.checkUser(userName, pass);
        return result;
    }
}
