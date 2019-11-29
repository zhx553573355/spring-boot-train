package com.zx.train.controller;

import com.zx.train.service.WordCacheService;
import com.zx.train.service.WordRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class WordRedisController {

    @Autowired
    WordRedisService wordRedisService;

    /**
     * 随机获取N个数字
     * @param modelMap
     * @param count
     * @return
     */
    @RequestMapping(value="getRandomWords")
    public String getRandomWords(ModelMap modelMap, Integer count){
        List<String> words=  wordRedisService.getRandomWords(count);
        System.out.println(words.toString());
        return words.toString();
    }

}
