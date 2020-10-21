package com.gof.code.proxy;

/**
 * @author: cxz
 * @create: 2020/8/11 16:28
 * @description:
 **/
public class ProxyImage implements Image {

    private RealImage realImage;

    public ProxyImage() {
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage();
        }
        realImage.display();
    }
}
