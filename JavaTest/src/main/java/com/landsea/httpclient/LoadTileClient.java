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
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.SimpleFormatter;

/**
 * Created by SDL on 2015/9/10.
 */
public class LoadTileClient {
    private static final Logger logger = Logger.getLogger(LoadTileClient.class);

    private String path;

    private ExecutorService executor = null;

    // 判断可是线程池可以结束
    private int waitTime = 500;

    LoadTileClient(String path) {
        this.path = path;
        //产生一个 ExecutorService 对象，这个对象带有一个大小为 poolSize 的线程池，
        //若任务数量大于 poolSize ，任务会被放在一个 queue 里顺序执行。
        executor = Executors.newFixedThreadPool(5);
    }

    public void setPath(String path) {
        this.path = path;
    }

    String getTileUri(int z, int x, int y) {
        return path + z + "/" + x + "/" + y;
    }

    void loadLevelTiles(int level, String destinationPath) throws IOException {


        int dimension = (int) Math.pow(2, level);
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                String uri = getTileUri(level, i, j);
                LoadTileThread thread = new LoadTileThread(i, uri, destinationPath);
                executor.execute(thread);
            }

        }
    }

    void waitThreadStop() {
        try {
            Thread.sleep(waitTime);
            executor.shutdown();
            executor.awaitTermination(waitTime, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ignored) {
        }
    }

    public static void main(String[] args) throws IOException {


        Date startTime = new Date();
        String uripath = "http://192.168.104.246:8080/WebchartServer/getTile/0/0/";

        String filepath = "F:/TileImages/";
        LoadTileClient loadTileClient = new LoadTileClient(uripath);

        int maxLevel = 7;
        for (int i = 0; i <= maxLevel; i++) {
            loadTileClient.loadLevelTiles(i, filepath);
        }

        Date endTime = new Date();

        long diff = endTime.getTime() - startTime.getTime();

        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);

        long diffHours = diff / (60 * 60 * 1000);

        long diffDays = diff / (24L * 60 * 60 * 1000);

        logger.info("用时: " + diffMinutes + "分钟" + diffSeconds + "秒" + diff + "毫秒.");

        loadTileClient.waitThreadStop();
    }
}
