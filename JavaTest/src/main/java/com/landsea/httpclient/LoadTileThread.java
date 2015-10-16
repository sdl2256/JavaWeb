package com.landsea.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by SDL on 2015/9/10.
 */
public class LoadTileThread extends Thread {
    private static final Logger logger = Logger.getLogger(LoadTileThread.class);

    private int level;
    private String uri;
    private String filepath;
    private CloseableHttpClient httpclient = null;

    public LoadTileThread(int level, String uri, String filepath) {

        httpclient = HttpClients.createDefault();
        this.level = level;
        this.uri = uri;
        this.filepath = filepath;
    }

    @Override
    public void run() {
        try {
            logger.info(currentThread().getName() + " is running.");
            HttpGet httpGet = new HttpGet(uri);
            CloseableHttpResponse response1 = httpclient.execute(httpGet);

            if (response1.getStatusLine().getStatusCode() == 200) {
                if (filepath == null || filepath == "")
                    filepath = getClass().getResource("/").getPath();
                if (!filepath.substring(filepath.length() - 1).equals("/"))
                    filepath += "/";
                String tmp = uri.substring(uri.indexOf("getTile/0/0/"), uri.length()).replace("getTile/0/0/", "");
                String filename = filepath + tmp + ".jpg";

                try {
                    HttpEntity entity1 = response1.getEntity();

                    File path = new File(filename.substring(0, filename.lastIndexOf("/")));
                    if (!path.exists()) {
                        path.mkdirs();
                    }
                    File storeFile = new File(filename);
                    FileOutputStream output = new FileOutputStream(storeFile);

                    if (entity1 != null) {
                        entity1.writeTo(output);
                        logger.info(Thread.currentThread().getName() + ": " + filename + " 保存成功！");
                        output.close();
                    }
                } finally {
                    response1.close();
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
