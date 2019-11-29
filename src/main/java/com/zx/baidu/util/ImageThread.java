package com.zx.baidu.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 异步生成图片
 */
public class ImageThread implements Runnable {

    BufferedImage image;
    File dstFile;

    /**
     *
     * @param image
     * @param dstFile
     */
    public ImageThread(BufferedImage image, File dstFile) {
        this.image = image;
        this.dstFile = dstFile;
    }

    @Override
    public void run() {
        try {
            ImageIO.write(image, "png", dstFile);
            System.out.println(dstFile);
            image.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        image.flush();
    }
}
