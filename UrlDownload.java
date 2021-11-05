package com.yu.udpDown;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlDownload {
    public static void main(String[] args) throws IOException {
        //1.下载地址
        URL url = new URL("https://m701.music.126.net/20211105201427/cca88a1acea0a719bf9345c5825c1c7e/jdyyaac/obj/w5rDlsOJwrLDjj7CmsOj/11377961129/3b6e/308e/d5ec/7f700c7d5bf17b2131dd07181eb3c054.m4a");
        //2.连接到这个资源
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("G:\\myMusic", "lemon-米津玄师.m4a"));

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        fos.close();
        inputStream.close();
        urlConnection.disconnect();

    }

}
