package com.ssm.common.getui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;



/**
 * @Description: 个推demo
 * @author harry.zhang
 * @CreateDate:	2017年7月11日
 * @version 1.0
 */
public class AppPush {

    //定义常量, appId、appKey、masterSecret 采用本文档 "第二步 获取访问凭证 "中获得的应用配置
    private static String appId = "qs7TAAijc78EYeZr2nbZZ3";
    private static String appKey = "4tYioFVKcT7xJdgold5iT2";
    private static String masterSecret = "hZcEq5a57U8pAEySOcWpR8";
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";
    
    public static void main(String[] args) throws IOException {

        IGtPush push = new IGtPush(url, appKey, masterSecret);

        // 定义"点击链接打开通知模板"，并设置标题、内容、链接
        LinkTemplate template = new LinkTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setTitle("欢迎使用个推!");
        template.setText("这是一条推送消息~");
        template.setUrl("http://getui.com");

        List<String> appIds = new ArrayList<String>();
        appIds.add(appId);

        // 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
        AppMessage message = new AppMessage();
        message.setData(template);
        message.setAppIdList(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000 * 600);

        IPushResult ret = push.pushMessageToApp(message);
        System.out.println(ret.getResponse().toString());
    }
}