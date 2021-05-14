package com.boot.google.recaptcha.controller;

import cn.hutool.extra.servlet.ServletUtil;
import com.boot.google.result.MyResult;
import com.boot.google.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: com.boot.google.recaptcha.controller
 * @ClassName: RecaptchaController
 * @Description: This is RecaptchaController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-14 14:30
 */
@RestController
@RequestMapping("/api/recaptcha")
public class RecaptchaController {
    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/v2/login")
    public MyResult loginV2(String username, String password, String token) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("token", token);
        Map<String, Object> result = MyUtil.siteVerify("6LcbKNIaAAAAAKHF0allEXBB4MlMF1GAdcU74ij3",token, ServletUtil.getClientIP(httpServletRequest));
        return new MyResult(200, "success", result);
    }

    @RequestMapping("/v3/login")
    public MyResult loginV3(String username, String password, String token) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("token", token);
        Map<String, Object> result = MyUtil.siteVerify("6LcLXtQaAAAAALgvUSPeMpqgQBzangelllSqND-Z",token, ServletUtil.getClientIP(httpServletRequest));
        return new MyResult(200, "success", result);
    }

}
