package com.zx.train;


import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

public class Test8 {
    @Test
    public void test(){
        System.out.println(DigestUtils.md5DigestAsHex("1234".getBytes()));

    }}
