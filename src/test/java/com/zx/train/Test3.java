package com.zx.train;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * 图片文字提取
 */
public class Test3 {

    //设置APPID/AK/SK
    public static final String APP_ID = "17723363";
    public static final String API_KEY = "aD4SDTgEISUlAB0sm60cbOSb";
    public static final String SECRET_KEY = "0xlOrGhRxZG3ZZeZ7tZ9S3e8NzaM7Oc5";

    public static void main(String[] args) {

        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);


        String path = "C:\\Users\\Yue\\Desktop\\14.png";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());


    }
}
