package com.zx.train;

import com.baidu.aip.ocr.AipOcr;
import com.zx.baidu.service.WordService;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class BaiduWordOcr {
    //设置APPID/AK/SK
    public static final String APP_ID = "17723363";
    public static final String API_KEY = "aD4SDTgEISUlAB0sm60cbOSb";
    public static final String SECRET_KEY = "0xlOrGhRxZG3ZZeZ7tZ9S3e8NzaM7Oc5";

    public static void main(String[] args) throws IOException, JSONException {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "classpath:log4j.properties");

        // 调用接口
        String path = "C:\\Users\\Yue\\Desktop\\14.png";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());

        System.out.println(res.toString(2));

        //解析词汇
        WordService wordService=new WordService();
        wordService.resolveWordResults(res);
    }
}
