package com.zx.train.service;

import com.zx.baidu.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * redis操作词汇
 */
@Service
public class WordRedisService {
    //redis单词总数
    private  Integer redisAllWordCount=0;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private WordDao wordDao;



    /**
     * 初始化词汇，将所有的词汇加入Redis服务器中
     * @throws IOException
     */
    public void initAddWordToRedis() throws IOException {
        List<String> allWordsList=wordDao.readAllWordList();
        int i=1;
        for(String word:allWordsList){
            stringRedisTemplate.opsForValue().set(String.valueOf("word"+i),word);
            i++;
        }
        //所有词汇加载完成之后，将总数添加入缓存中
        this.redisAllWordCount=i-1;
        stringRedisTemplate.opsForValue().set("redisAllWordCount",String.valueOf(this.redisAllWordCount));
    }



    /**
     * 随机获取N个词汇
     * @param count
     * @return
     */
    public List<String> getRandomWords(Integer count){
        List<String> wordsList=new ArrayList<>();
        Integer allwordsCount=Integer.valueOf(stringRedisTemplate.opsForValue().get("redisAllWordCount"));

        //循环生成固定数量的词汇
        for (int i=0;i<count;i++){
           Integer random= new Double(Math.ceil(Math.random()*allwordsCount)).intValue();
            String word=stringRedisTemplate.opsForValue().get(String.valueOf("word"+random));
            wordsList.add(word);
        }
        return wordsList;
    }

}
