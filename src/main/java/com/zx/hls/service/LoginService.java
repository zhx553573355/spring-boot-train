package com.zx.hls.service;

import com.zx.hls.dao.SysUserRepo;
import com.zx.hls.exception.ExceptionEnum;
import com.zx.hls.exception.HttpResult;
import com.zx.hls.exception.HttpResultUtil;
import com.zx.hls.pojo.SysUser;
import com.zx.hls.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    SysUserRepo sysUserRepo;


    /**
     *校验账户
     * @param userName
     * @param pass
     * @return
     */
    public HttpResult checkUser(String userName, String pass){

        HttpResult result = HttpResultUtil.success();

        if ("".equals(userName) || "".equals(pass) ){
            result.setStatus(-1);
            result.setMsg("账号或者密码为空");
            return result;
        }
            //调用数据库进行校验
           SysUser user=sysUserRepo.findByUserNameAndEncryptedUserPassword(userName.toUpperCase(), MD5.toMD5(pass));
           if(user ==null) {
               result =  HttpResultUtil.error(ExceptionEnum.USER_NOT_FIND);
           }
               else{
               result =  HttpResultUtil.success(user);
           }
               return result;
    }

    /**
     * 校验验证码
     * @param validCode
     */
    public void checkValidCode(String validCode){

    }

}
