package com.java.study.tika;

import com.alibaba.fastjson.JSON;
import org.apache.tika.Tika;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author: cxz
 * @create: 2021/1/29 14:30
 * @description:
 **/
public class Demo {

    public static void main(String[] args) throws IOException {
        Tika tika = new Tika();
        System.out.println(tika.parse(new URL("https://www.jd.com")));
        System.out.println(JSON.toJSONString(tika));
    }
}
