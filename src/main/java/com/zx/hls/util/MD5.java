package com.zx.hls.util;

import org.springframework.util.DigestUtils;

/**
 * MD5加密
 */
public  class MD5 {
    /**
     * MD5对字符串进行加密之后，转换成大写
     * @param text
     * @return
     */
    public static String toMD5(String text){
       return  DigestUtils.md5DigestAsHex(text.getBytes()).toUpperCase();
    }
}
