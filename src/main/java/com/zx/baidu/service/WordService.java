package com.zx.baidu.service;

import com.zx.baidu.dao.WordDao;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class WordService {

    public WordService(){}


    /**
     * 解析图片文字
     * @param wordsResult
     * @throws IOException
     */
    public void resolveWordResults(JSONObject wordsResult) throws IOException {

        WordDao wordDao=new WordDao();
        // 获取所有解析的行
        List<String> wordsList=getWordList(wordsResult);
        wordDao.writeWordList(wordsList);
    }

    /**
     * 解析返回的json数组，并返回所有词汇
     * @param wordsResult
     * @return
     */
     List<String> getWordList(JSONObject wordsResult){
        List<String> wordsList=new ArrayList<String>();

        JSONArray wordsResultsList=wordsResult.getJSONArray("words_result");

        if(wordsResultsList!=null && wordsResultsList.length()>0)
        for (int i=0;i< wordsResultsList.length();i++){
            String sentence =wordsResultsList.getJSONObject(i).getString("words");
            List<String> wordList=getWords(sentence);
            for(String word:wordList ){
                wordsList.add(word);
            }
        }

        return wordsList;
    }

    /**将每句话中的词汇提取出来，【词汇】
     *
     * @param sentence
     * @return
     */
      List<String> getWords(String sentence){
        List<String> wordsList=new ArrayList<>();

        if("".equals(sentence)) return wordsList;

        while(sentence.length()>0){
            Integer charBeginIndex=sentence.indexOf("【");
            if (charBeginIndex<0) return wordsList;

            Integer charEndIndex=sentence.indexOf("】");
            if (charEndIndex<0) return wordsList;

            //如果括号不是成对出现，则忽略,
            if (charBeginIndex>charEndIndex){
                sentence=sentence.substring(charEndIndex+1,sentence.length());
                continue;
            }

            String word=sentence.substring(charBeginIndex+1, charEndIndex);

            //大于4个字的词语不录入
            if (word.length()<=4) {
                wordsList.add(word);
            }
            sentence=sentence.substring(charEndIndex+1,sentence.length());
        }

        return wordsList;
    }


    /**
     * 读取word词汇
     * @throws IOException
     */
    public void getWord() throws IOException {
          WordDao wordDao=new WordDao();
        List<String> words=   wordDao.readAllWordList();

    }

}
