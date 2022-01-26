package com.tim.learn.baidu;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @Author: yangxz
 * @Description:
 * @CreateDate: 2021/2/25/025 9:36
 * @Version: 1.0
 */
public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "23704430";
    public static final String API_KEY = "9B2AgXsTocRGGXc2aeWITHPH";
    public static final String SECRET_KEY = "MDfhkolvXbROcuGtFsfGLQ86m1HGHeOa";

    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

//        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "D:\\2\\1\\123.jpg";
        JSONObject res = client.webimageLoc(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }
}
