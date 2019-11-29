package com.zx.train;

import com.zx.hls.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan(basePackages={"com.zx.*"})
public class Test7 {
    @Autowired
    LoginService    loginService;

    @Test
    public void test(){
        loginService.checkUser("ZHANG","123" );
    }

}
