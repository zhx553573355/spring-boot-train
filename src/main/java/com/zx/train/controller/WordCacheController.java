package com.zx.train.controller;

import com.zx.train.service.WordCacheService;
import com.zx.train.service.WordRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class WordCacheController {

    @Autowired
    WordCacheService wordCacheService;

    @RequestMapping(value="getRandomWords2")
    public String getRandomWords2(Integer count){
        List<String> words=  wordCacheService.getRandomWords(count);
        System.out.println(words.toString());
        return words.toString();
    }

}
