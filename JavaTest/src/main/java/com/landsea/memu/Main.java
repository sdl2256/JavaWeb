package com.landsea.memu;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDL on 2015/7/13.
 */
public class Main {
    public static void main(String[] args) {
        String url = "http://192.168.104.76:8080/seamap/common/rightURLQuery.action";
        String username = "%E9%99%86%E5%94%AF%E4%B8%80";
        String password = "2";

        MenuHttpClient menuHttpClient = new MenuHttpClient();
        String result = menuHttpClient.getHttp(url, username, password);


        ConfigGroup configGroup = new ConfigGroup();
        configGroup.setVersion("0.1");
        configGroup.setProject("上海远洋");
        List<ContextMenuConfig> menuConfigs = new ArrayList<ContextMenuConfig>();
        ContextMenuConfig contextMenuConfig = new ContextMenuConfig();
        contextMenuConfig.setName("");
        contextMenuConfig.setId("1");

        List<MenuButtonConfig> buttonConfigs = new ArrayList<MenuButtonConfig>();
        List<Menu> menus = menuHttpClient.splitResult(result, "http://192.168.104.76:8080");
        int i = 1;
        for (Menu menu : menus) {

            String urlTmp = "";
            MenuButtonConfig menuButtonConfig = new MenuButtonConfig();
            String menuId = Integer.toString(i++);
            contextMenuConfig.add(menuId);
            menuButtonConfig.setId(menuId);
            menuButtonConfig.setName(menu.getName());
            List<String> urlParams = new ArrayList<String>();
            if (menu.getParaUserid().equals("1")) {
                menuButtonConfig.setUserName("a");
                menuButtonConfig.setPassword("b");
            }
            if (menu.getParaShipid().equals("1")) {
                urlParams.add("callsign");
                urlTmp = menu.getUrl() + "?c={callsign}";
            }
            menuButtonConfig.setUrlTemplate(urlTmp);
            menuButtonConfig.setUrlParams(urlParams);

            buttonConfigs.add(menuButtonConfig);
        }


        menuConfigs.add(contextMenuConfig);

        configGroup.setMenuConfigs(menuConfigs);

        configGroup.setButtonConfigs(buttonConfigs);

        String s = JSON.toJSONString(configGroup);

        System.out.println(s);
    }
}
