package com.zx.hls.controller;

import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import com.zx.hls.exception.HttpResult;
import com.zx.hls.exception.HttpResultUtil;
import com.zx.hls.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/userinfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value="getuserid")
    public HttpResult getDdUserId(String authcode) throws ApiException {
        HttpResult httpResult= HttpResultUtil.success();
       String userid= userInfoService.getDdUserId(authcode);
        if (userid==null){
            httpResult=HttpResultUtil.error(-1, "获取userid失败");
        }else{
            JSONObject userJson=new JSONObject();
            userJson.put("userid", userid);
            httpResult=HttpResultUtil.success(userJson);
        }
        return httpResult;
    }

}
