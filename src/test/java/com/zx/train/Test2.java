package com.zx.train;

import com.zx.baidu.service.PdfService;

import java.io.FileNotFoundException;

//将PDF转换成图片
public class Test2 {
    public static void main(String[] args) throws FileNotFoundException {
        //异步多线程将PDF转图片
        PdfService pdf=new PdfService();
        pdf.pdf2ImageThread(pdf.WORD_PDF_FILE_PATH, pdf.WORD_IMAGE_DIR_PATH, 600,0);
    }
}
