package com.zx.hls.service;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.taobao.api.ApiException;
import org.springframework.stereotype.Service;

/**
 * 获取钉钉的客户信息
 */
@Service
public class UserInfoService {

    private final String appkey="dingv16lb9womf0beaoo";
    private final String appsecret="x-mHF6kLhRuxpmC0AMk5cBowyiQte7B1LH_f2BjZiAm-niYFkm8d-hj6MQbDNxR0";

    /**
     * 获取钉钉的accessToken
     * @return
     * @throws ApiException
     */
    public String getAccessToken() throws ApiException {
        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(appkey);
        request.setAppsecret(appsecret);
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        String accessToken=response.getAccessToken();
        return accessToken;

    }

    /**
     * 获取钉钉用户的唯一标识UserID
     * @param requestAuthCode
     * @return
     * @throws ApiException
     */
    public String getDdUserId(String requestAuthCode) throws ApiException {
        String accessToken=getAccessToken();


        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/getuserinfo");
        OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
        request.setCode(requestAuthCode);
        request.setHttpMethod("GET");

        OapiUserGetuserinfoResponse response = client.execute(request, accessToken);
        System.out.println(response.getUserid());
        System.out.println(response.getErrmsg());

        String userId = response.getUserid();
        return userId;
    }

}
