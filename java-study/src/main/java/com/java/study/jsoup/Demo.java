package com.java.study.jsoup;

import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author: cxz
 * @create: 2021/1/29 14:41
 * @description:
 **/
public class Demo {

    public static void main(String[] args) throws IOException {
        String url = "https://xiapi.xiapibuy.com/%E3%80%90%E7%86%B1%E8%B3%A3%F0%9F%8C%B9%E7%89%B9%E5%83%B9%E3%80%91-%E5%A5%B3%E5%A3%AB%E5%8C%85%E5%8C%852021-%E6%B5%81%E8%A1%8C%E6%96%B0%E6%AC%BE%E5%A4%A7%E5%AE%B9%E9%87%8F-%E6%B2%B9%E8%A0%9F%E7%9A%AE%E5%96%AE%E8%82%A9%E5%8C%85-%E7%99%BE%E6%90%AD-%E6%96%9C%E6%8C%8E-%E5%A4%A7%E6%B0%A3-%E6%89%8B%E6%8F%90-%E6%89%98%E7%89%B9%E5%8C%85-%E6%99%82%E5%B0%9A-%E6%B0%A3%E8%B3%AA-%E8%B3%AA%E6%84%9F-%E5%8C%85%E5%8C%85-i.355227462.4377040256";
        Document document = Jsoup.parse(new URL(url), 30000);
        //Element element = document.getElementById("J_goodsList");
        //Elements elements = element.getElementsByTag("li");
//        for (int i = 0; i <elements.size() ; i++) {
//            String img = elements.get(i).getElementsByTag("img").eq(0).attr("data-lazy-img");
//            String price = elements.get(i).getElementsByClass("p-price").get(0).getElementsByTag("i").eq(0).text();
//            String name = elements.get(i).getElementsByClass("p-name").get(0).getElementsByTag("i").eq(0).text();
//            System.out.println(img);
//            System.out.println(price);
//            System.out.println(name);
//            System.out.println("=============");
//        }

        System.out.println(JSON.toJSONString(document.getElementsByClass("_36_A1j")));
    }
}
