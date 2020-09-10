package com.bbim;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


class WebCrawler {
    public static void main(String[] args) throws Exception {
        try {
            // 具体方法可以查看 jsoup 文档
            Document doc = Jsoup.connect("https://news.sina.com.cn/world/").get();
            //标题
            //带有href属性的a元素
            Elements links = doc.select("a[href]");
            //取出所有图片
            Elements imgs = links.select("[src]");
            //取出所有图片链接
            for (Element img : imgs) {
                System.out.print(img.absUrl("src"));
                System.out.println(img.attr("alt"));
            }
            for (Element link : links) {
                //取出链接地址中的文本内容
               link.text();
            }
            //获取body下的所有所有文本
            doc.body().text();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


