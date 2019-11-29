package com.zx.train;

import com.zx.baidu.service.ImageService;
import com.zx.baidu.service.OcrService;
import com.zx.baidu.service.PdfService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * 测试图片读取
 */
public class Test4 {
    public static void main(String[] args) throws IOException, InterruptedException {
        //获取需要解析的所有图片路径
        ImageService imageService=new ImageService();
      List<String> imagePathList= imageService.getDirAllImageList(PdfService.WORD_IMAGE_DIR_PATH);
        System.out.println("图片数量:"+imagePathList.size());
      //获取已经解析的图片路径
        List<String> completeImagePathList= imageService.getCompleteFiles(ImageService.MEMORY_COMPLETE_FILE_PATH);
        System.out.println("已解析图片数量:"+completeImagePathList.size());

        for(String imagePath:imagePathList){
            System.out.println("待解析图片："+imagePath);
            Thread.sleep(500);
            //如果已经读取过，则不再读取该图片信息
            if(completeImagePathList.contains(imagePath))continue;

            //开启多线程同时解析图片
            OcrService ocrService=new OcrService(imagePath);
            Thread thread=new Thread(ocrService);
            thread.start();
        }


    }
}
