package com.zx.train.service;

import com.zx.baidu.dao.WordDao;
import com.zx.train.start.InitWords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 单机缓存
 */
@Service
public class WordCacheService {

    @Autowired
    WordDao wordDao;

    /**
     * 初始化缓存数据
     * @throws IOException
     */
    public void InitAddWordToCatch() throws IOException {
        List<String> allWordsList=wordDao.readAllWordList();
        int i=1;
        for(String word:allWordsList){
            InitWords.AllWordsMap.put(String.valueOf("word"+i),word);
            i++;
        }
        //所有词汇加载完成之后，将总数添加入缓存中
        InitWords.AllWordsMap.put("cacheAllWordCount",String.valueOf(i+1));
    }


    /**
     * 随机获得N个词汇
     * @param count
     * @return
     */
    public List<String> getRandomWords(Integer count){
        List<String> wordsList=new ArrayList<>();
        Integer allwordsCount=Integer.valueOf(InitWords.AllWordsMap.get("cacheAllWordCount"));

        //循环生成固定数量的词汇
        for (int i=0;i<count;i++){
            Integer random= new Double(Math.ceil(Math.random()*allwordsCount)).intValue();
            String word=InitWords.AllWordsMap.get("word"+random);
            wordsList.add(word);
        }
        return wordsList;
    }

}
