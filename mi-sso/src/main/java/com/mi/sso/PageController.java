package com.mi.sso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 * 页面跳转控制
 *
 * @author 金彪
 * @date 2021-02-01
 */
@Controller
@RequestMapping("/page")
public class PageController {

    /**
     * 跳转到登录页
     *
     * @return
     */
    @GetMapping("/login")
    public String toLogin(@RequestParam(required = false, defaultValue = "") String target,
                          HttpSession session, @CookieValue(required = false, value = "TOKEN") Cookie cookie) {

        // 如果是已登录的用户再次访问登录页面，就要重定向
        if (cookie != null) {
            String value = cookie.getValue();
            User user = LoginCacheUtil.loginUser.get(value);
            if (user != null) {
                return "redirect:" + target;
            }
        }
        // 用于登录成功后重定向地址
        session.setAttribute("target", target);
        return "login";
    }

    /**
     * 用户直接访问登录页
     *
     * @return
     */
    @RequestMapping("/index")
    public String loginIndex() {
        return "login";
    }
}
