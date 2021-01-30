package com.mi.sys.controller;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.baomidou.mybatisplus.extension.api.ApiController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 秒杀模块
 */
@Controller
@RequestMapping("/api/pay")
@Slf4j
public class AlipayDemoContoller extends ApiController {

    @GetMapping("/test")
    public void pay(HttpServletResponse response) throws AlipayApiException, IOException {
        AlipayClient alipayClient = new DefaultAlipayClient(
                "https://openapi.alipaydev.com/gateway.do",
                "2021000117606525",
                "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCJxOAZo8XOnf+mKHAL7smzgwxl4W8Hq8gUp5VLgZD8SKboVeA3cu73zNTgjabDnZQ4snUruyYQtuajkxYAeGZdx8yuhZ7lhn+shKdtAZH6hLjAExs9DPUiaJhJZ0Pwy9EXz0rOw+4QvBADyyPX5TDMhVsVApVdBaRSL3D7eL9ePKktZ3jQcbOJMUUz6CpFT51le+0yW5Ub4ORgY13HvSTXAks6mRCH14AmaMew0F8/h5PZcSI8tn5jIKEif5Yba5filQUSBNoffgMU1KLzNjto9hikVY6XcJ4u1IQXWxcBbpUJULTYCw9N6/wmI1FlCxkGcrYJaA75sDQ7tTtT49IRAgMBAAECggEAKXz4X8BKGWbLTiZvV6iZZU3ZtfSlkxHQNyggdZSXLOJUITN7Sjd6b3VnxhfiWJZjxI85aen6FJ5/5lKtFYcsjKFWqlfi+gv+9t0b7l/Crka5vF4EneYBDFOjSLeoZiN63Ei4pnuqfa+kwv+x05pZj725KCKXCGRij71psNE0EBSPXm+WhPEgvvSgccVgCdGfrA1vv5fdpLKefIeXObP858eUQiCsbu6CB3CEpGD3D+l8ccKyCmJ2ualHlM4M77doTYR69zEAYWjshG6NnveSndTYuGxiulG3lfoUbsWI2SgseTwfmA20qXk0FuAGvsB5I057pecUq955I6fKe37o4QKBgQD07EoVdMAfyU5AGzEqxZwVsEINC0ztZWtFU3GVywzNsIwYt+AHQRPhYqVt+5WRypZqZx3hx86ntxohEqAiUUEWcIeYfg2+a2h7LZv5XY1VpgTi6IdVsnkOclKiuHBc8gQR+weKMAji6G8QrZH0tmxpzNmMx7p3O8Nmjn14QVXKywKBgQCP//X+vxwTLYBySHoqXb88m9cJmGD6+wxA8UNLp3PBxtTjADhhYc9VbRURa7AfHLsKlbjLBvR77HdiuFJoF7q+0DadTVmx7kgyiPVknCE/+JkgzrqsMwxKbBBtwp03OTjWQskanx6LkF9ghbF1MAfoj4ZJ4xvDSXRdk+LMeQ+vEwKBgQDXybt37fY7yzPbPVnzUkmzvihjr7omSr3ZRayEinKMYuj7+j0yhv7KDAyuuwNLgQ9HTfTA8Ta9A5DM5MkbkzViXODK1Pys8ZsLM+MBMJCOjogtlyttsKIBvW3bGd89tKkrYl2BPdMGgD0il5pJ3dPk32wpIevCk3AUUqRvKDk7QwKBgBph08jrbJJa6MiHXNJ8QHgzOQ+J+mKhMhqH2UN4F24uJny8Ypf82oaVKKH7b9YTZnVG/wc7a/l0Vl8g1AA8MLua3BavwDooJNQVYZggPrtAqZVoKq034Q2VhOEHIdSnSDGBJOUat/br6X1+oQeOWDSUbw8Ea+a4g3hNiuTZXTU/AoGBAIWh0eJBSuMUjVGhvcInzq8MOweqZbdx8qdPbJ3/0WyR82yISut2aodtKC9YHnYMsSjDRZxG+ioCOA3lqAQEuAtZe4WYWRP6H+RyhhMhTjl+KWrGpJaCI8IxYi5ubW9sXUJDY+v7aB82JNuAxMfJs1CpdRYJ5n062viAJprhT2+D",
                "json",
                "utf-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi+5EPwCDKTPp1b92RO0FqzA86Cw4FNCeAzrfzMCl+wHt3bNCDVmqE4ZSM0Up2buZawszJ3m2+utlVsd2agcmLpo7sRzxwj6N1rTJLyZiJPeyTInP+Xf+Rtw1rFRe8JsFQhRrKFdthb8qPbq6VtvlrvBXZCAr4Hoeop9GfYbjOV3AklIVuvoOuzixWrY4rlg8Zc7LthAkhtH9ZxlCm13/ZfBLQXfcrYz2p5SffTYlc00tqp9oiTHnvQxIHlcosrgjKMbLC0Gch25IS7gOk6bDPASPx7/MIuN97xsbMHFhlMuSzQEEWLQ/qpPo079LoJ37GdITmaaPinFclTmXWsgUDwIDAQAB",
                "RSA2");  //获得初始化的AlipayClient
        AlipayTradePrecreateRequest aliRequest = new AlipayTradePrecreateRequest(); //创建API对应的request类
        aliRequest.setBizContent("{" +
                "\"out_trade_no\":\"201503200177152002\"," + //商户订单号
                "\"total_amount\":\"99999.99\"," +
                "\"subject\":\"Iphone6 16G\"," +
                "\"store_id\":\"NJ_001\"," +
                "\"timeout_express\":\"90m\"}"); //订单允许的最晚付款时间
        AlipayTradePrecreateResponse aliResponse = alipayClient.execute(aliRequest);
        String qrCode = aliResponse.getQrCode();
        QrCodeUtil.generate(qrCode, 300, 300, ImgUtil.IMAGE_TYPE_JPG, response.getOutputStream());
    }
}
