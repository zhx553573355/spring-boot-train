package com.zx.baidu.service;

import com.baidu.aip.ocr.AipOcr;
import com.sun.javafx.geom.BaseBounds;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * 百度Ocr识别图片
 */
public class OcrService implements Runnable {

    //设置APPID/AK/SK
    private static final String APP_ID = "17723363";
    private static final String API_KEY = "aD4SDTgEISUlAB0sm60cbOSb";
    private static final String SECRET_KEY = "0xlOrGhRxZG3ZZeZ7tZ9S3e8NzaM7Oc5";

    private String imagePath;

    public OcrService(){

    }

    /**
     * 多线程运行时，传递图片地址参数，
     * @param imagePath
     */
    public OcrService(String imagePath){
        this.imagePath=imagePath;
    }


    public void setHttp(String imagePath) throws IOException {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用接口
        JSONObject res = client.basicGeneral(imagePath, new HashMap<String, String>());
        System.out.println("-----OCR解析结果------------");
        System.out.println(res.toString());
        //解析词汇
        WordService wordService=new WordService();
        wordService.resolveWordResults(res);
    }


    @Override
    public void run() {
        try {
            //调用百度OCR解析图片文字
            setHttp(this.imagePath);

            //图片处理完成之后，将图片路径写入文件中
            ImageService imageService = new ImageService();
            imageService.addCompleteFile(ImageService.MEMORY_COMPLETE_FILE_PATH, imagePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
