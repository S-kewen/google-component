package com.boot.google.util;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: com.boot.google.util
 * @ClassName: MyUtil
 * @Description: This is MyUtil class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-14 14:53
 */
@Component
public class MyUtil {
    public static Map<String, Object> siteVerify(String secret, String token, String ip) {
        Map<String, Object> map = new HashMap<>();
        String result = HttpUtil.post("https://www.google.com/recaptcha/api/siteverify", "secret=" + secret + "&response=" + token + "&remoteip=" + ip);
        System.out.println(result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        map.put("result", result);
        map.put("status", jsonObject.getBoolean("success"));
        return map;
    }
}
