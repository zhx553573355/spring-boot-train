package com.zx.baidu.service;

import com.zx.baidu.util.ImageThread;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 将PDF转换成图片
 */
public class PdfService {
    //词典PDF路径
    public static final  String WORD_PDF_FILE_PATH="classpath:memory_files_dir/现代汉语词典第6版.pdf";
    //PDF图片存放路径
    public static final String WORD_IMAGE_DIR_PATH="classpath:memory_files_dir/images";

    public void PDFService(){

    }


    /***
     * PDF文件转PNG图片,单线程
     * @param PdfFilePath pdf完整路径
     * @param dpi dpi越大转换后越清晰，相对转换速度越慢
     * @param flag 页数 为0则转换全部页数
     * @return
     */
    public static void pdf2Image(String PdfFilePath, String dstImgFolder, int dpi,int flag) throws FileNotFoundException {
        File file = ResourceUtils.getFile(PdfFilePath);
        File imageDir=ResourceUtils.getFile(dstImgFolder);

        PDDocument pdDocument;
        try {
            pdDocument = PDDocument.load(file);

            PDFRenderer renderer = new PDFRenderer(pdDocument);
            int pages = pdDocument.getNumberOfPages();
            if(flag > 0) {//大于0则打印具体页数
                if(flag<pages) {
                    pages = flag;
                }
            }
            StringBuffer imgFilePath = null;
            System.out.println("总页数："+pages);
            for (int i = 0; i < pages; i++) {
                String imgFilePathPrefix = imageDir.getAbsolutePath()+ File.separator + (i+1);
                imgFilePath = new StringBuffer();
                imgFilePath.append(imgFilePathPrefix);
                imgFilePath.append(".png");
                File dstFile = new File(imgFilePath.toString());
                BufferedImage image = renderer.renderImageWithDPI(i, dpi);

                ImageIO.write(image, "png", dstFile);
                image.flush();
            }
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
    }


    /**
     * 多线程生成图片
     * @param PdfFilePath
     * @param dstImgFolder
     * @param dpi
     * @param flag
     * @throws FileNotFoundException
     */
    public  void pdf2ImageThread(String PdfFilePath, String dstImgFolder, int dpi,int flag) throws FileNotFoundException {
        File file = ResourceUtils.getFile(PdfFilePath);
        File imageDir=ResourceUtils.getFile(dstImgFolder);

        PDDocument pdDocument;
        try {
            pdDocument = PDDocument.load(file);

            PDFRenderer renderer = new PDFRenderer(pdDocument);
            int pages = pdDocument.getNumberOfPages();
            if(flag > 0) {//大于0则打印具体页数
                if(flag<pages) {
                    pages = flag;
                }
            }
            StringBuffer imgFilePath = null;
            System.out.println("总页数："+pages);
            for (int i = 1615; i < pages; i++) {
                String imgFilePathPrefix = imageDir.getAbsolutePath()+ File.separator + (i+1);
                imgFilePath = new StringBuffer();
                imgFilePath.append(imgFilePathPrefix);
                imgFilePath.append(".png");
                File dstFile = new File(imgFilePath.toString());
                BufferedImage image = renderer.renderImageWithDPI(i, dpi);
                //采用多线程，可以异步处理，加快速度
                Thread thread=new Thread(new ImageThread(image,dstFile));
                thread.start();
            }
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
    }

    private  boolean createDirectory(String folder) throws FileNotFoundException {
        File dir = ResourceUtils.getFile(folder);
        if (dir.exists()) {
            return true;
        } else {
            return dir.mkdirs();
        }
    }
}
