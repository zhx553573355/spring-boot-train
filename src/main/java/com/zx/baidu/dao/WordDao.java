package com.zx.baidu.dao;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WordDao {

    //解析的word词汇存放路径
    private final String MEMORY_WORD_FILE_PATH="classpath:memory_files_dir/memory_word.txt";

    public WordDao(){

    }

    /**
     * 将词语保存到txt中,增加事务锁，避免出现数据丢失
     * @param wordsList
     * @throws IOException
     */
    public synchronized void writeWordList(List<String> wordsList) throws IOException {
        FileOutputStream  outputStream;
        File file= ResourceUtils.getFile(MEMORY_WORD_FILE_PATH);
        outputStream=new FileOutputStream(file,true);
        for(String word:wordsList){
            outputStream.write((word+"\n").getBytes("utf-8"));
        }
       outputStream.flush();
       outputStream.close();
        System.out.println("词汇添加完成--");
    }

    /**
     * 读取所有的单词
     * @return
     * @throws IOException
     */
    public List<String> readAllWordList() throws IOException {
        List<String> wordList=new ArrayList<String>();

        File file=ResourceUtils.getFile(MEMORY_WORD_FILE_PATH);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String strLine = null;
        while(null != (strLine = bufferedReader.readLine())){
            wordList.add(strLine);
        }

        return wordList;
    }


}
