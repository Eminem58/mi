package com.mi.sso;


import java.util.HashMap;
import java.util.Map;

/**
 * @author 金彪
 * @date 2021-02-01
 */
public class LoginCacheUtil {
    //模拟系统的数据缓存，如 Redis 之类的
    public static Map<String, User> loginUser = new HashMap<>();
}
