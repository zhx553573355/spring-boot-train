package com.zx.baidu.service;

import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 图片处理
 */
public class ImageService {

    //PDF图片存放路径
    public static final String WORD_IMAGE_DIR_PATH="classpath:memory_files_dir/images";

    //已解析的图片存放文件
    public static String MEMORY_COMPLETE_FILE_PATH="classpath:memory_files_dir/complete_image.txt";

    /**
     * 获取所有需要转PDF的目录文件清单列表
     * @return
     */
    public List<String> getDirAllImageList(String imageDirPath) throws FileNotFoundException {
        File imageDir= ResourceUtils.getFile(imageDirPath);
        List<String> imageFiles=new ArrayList<String>();

        if(!imageDir.isDirectory()){
            System.out.println("目录不存在："+imageDirPath );
        }else {
            File files[]=imageDir.listFiles();
            for(File f: files){
                imageFiles.add(f.getAbsolutePath());
            }
        }
        System.out.println("-----排序前-----------");
        System.out.println(imageFiles.toString());
        Collections.sort(imageFiles);
        System.out.println("-----排序后-----------");
        System.out.println(imageFiles.toString());
        return imageFiles;
    }

    /**
     * 图片被读取，写入文件,多线程执行，避免出现漏写的情况，
     * @param completeImageFilePath
     * @param imagePath
     * @throws IOException
     */
    public synchronized  void addCompleteFile(String completeImageFilePath,String imagePath) throws IOException {
        File file=ResourceUtils.getFile(completeImageFilePath);

        FileOutputStream outputStream=new FileOutputStream(file,true);

        outputStream.write((imagePath+"\n").getBytes());

        outputStream.flush();
        outputStream.close();


        System.out.println("图片处理完成--");

    }

    /**
     * 获取所有已经处理的图片
     * @param completeImageFilePath
     * @return
     * @throws IOException
     */
    public List<String> getCompleteFiles(String completeImageFilePath) throws IOException {
        List<String> completeFiles=new ArrayList<String>();

        File file=ResourceUtils.getFile(completeImageFilePath);
        FileInputStream inputStream=new FileInputStream(file);
        InputStreamReader streamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(streamReader);
        String readLine="";
        while((readLine=bufferedReader.readLine())!=null){
            completeFiles.add(readLine);
        }
        bufferedReader.close();
        streamReader.close();
        inputStream.close();

        return  completeFiles;
    }

}
