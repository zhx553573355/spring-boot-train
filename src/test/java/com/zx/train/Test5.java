package com.zx.train;


import com.zx.train.service.WordRedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
public class Test5 {

    @Autowired
    WordRedisService wordRedisService;

    @Test
    public void testWordRedis() throws IOException {
        wordRedisService.initAddWordToRedis();

        List<String> random= wordRedisService.getRandomWords(5);
        System.out.println(random.toString());
    }
}
