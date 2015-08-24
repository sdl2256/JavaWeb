package com.landsea.memu;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDL on 2015/7/13.
 */
public class MenuHttpClient {

    public String getHttp(String url, String username, String password) {

        String result = "";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url + "?a=" + username + "&b=" + password);
        CloseableHttpResponse response = null;

        try {
            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            String charset = "UTF-8";
            result = EntityUtils.toString(entity, charset);
        } catch (IOException e) {

        } finally {
            try {
                response.close();
            } catch (IOException e) {
            }

        }
        return result;
    }


    public List<Menu> splitResult(String result, String ip) {

        List<Menu> menus = new ArrayList<Menu>();
        String[] strings = result.split("<BR>");

        for (int i = 0; i < strings.length; i++) {
            Menu menu = new Menu();
            String[] para = strings[i].split(",");

            if (para.length <= 5) {
                continue;
            }
            menu.setName(para[0].replace("PR//", ""));
            menu.setUrl(para[1].replace("<svr>", ip));
            menu.setParaShipid(para[2]);
            menu.setParaUserid(para[3]);
            menu.setOrder(para[4]);
            menu.setShowMaxSize(para[5]);
            menus.add(menu);
        }
        return menus;
    }
}
