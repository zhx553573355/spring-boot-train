package com.zx.train;

import com.zx.baidu.service.WordService;

import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws IOException {

        WordService service=new WordService();
        service.getWord();
    }
}
