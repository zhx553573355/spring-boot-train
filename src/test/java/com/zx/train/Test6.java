package com.zx.train;

import com.baidu.aip.ocr.AipOcr;
import com.zx.baidu.service.ImageService;
import com.zx.baidu.service.OcrService;
import com.zx.baidu.service.PdfService;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Test6 {
    private static final String APP_ID = "17723363";
    private static final String API_KEY = "aD4SDTgEISUlAB0sm60cbOSb";
    private static final String SECRET_KEY = "0xlOrGhRxZG3ZZeZ7tZ9S3e8NzaM7Oc5";


    public static void main(String[] args) throws IOException, InterruptedException {
        //获取需要解析的所有图片路径
        ImageService imageService=new ImageService();
        List<String> imagePathList= imageService.getDirAllImageList("classpath:express_image_dir");
        System.out.println("图片数量:"+imagePathList.size());


        for(String imagePath:imagePathList){
            System.out.println("待解析图片："+imagePath);
            Thread.sleep(500);

            //开启多线程同时解析图片
            OcrService ocrService=new OcrService(imagePath);
            AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

            // 可选：设置网络连接参数
            client.setConnectionTimeoutInMillis(2000);
            client.setSocketTimeoutInMillis(60000);

            // 调用接口
            JSONObject res = client.basicGeneral(imagePath, new HashMap<String, String>());
            System.out.println("-----OCR解析结果------------");
            System.out.println(res.toString());
        }
    }
}
