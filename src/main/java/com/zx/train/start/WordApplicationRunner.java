package com.zx.train.start;

import com.zx.train.service.WordCacheService;
import com.zx.train.service.WordRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 项目启动时，执行该方法
 */
@Component
public class WordApplicationRunner implements ApplicationRunner {
//
    @Autowired
    WordRedisService wordRedisService;

    @Autowired
    WordCacheService wordCacheService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("-----将词汇添加入缓存-----");
        wordRedisService.initAddWordToRedis();

        System.out.println("-----将词汇添加入缓存-----");
        wordCacheService.InitAddWordToCatch();


    }
}

