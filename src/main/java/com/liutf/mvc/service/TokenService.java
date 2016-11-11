package com.liutf.mvc.service;

import com.liutf.mvc.entity.CheckModel;
import com.liutf.mvc.utils.EncoderHandler;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * @description: TODO
 * @author: liutf
 * @date: 2015年4月2日 上午11:35:24
 * @version: V1.0.0
 */
public class TokenService {

    /**
     * @description: 微信开发者验证
     * @param wxToken
     * @param tokenModel
     * @return
     * @author: liutf
     * @date: 2015年4月2日 下午12:42:58
     */
    @Transactional
    public String validate(String wxToken, CheckModel tokenModel) {
        String signature = tokenModel.getSignature();
        Long timestamp = tokenModel.getTimestamp();
        Long nonce = tokenModel.getNonce();
        String echostr = tokenModel.getEchostr();
        if (signature != null && timestamp != null & nonce != null) {
            String[] str = {wxToken, timestamp + "", nonce + ""};
            Arrays.sort(str); // 字典序排序
            String bigStr = str[0] + str[1] + str[2];
            // SHA1加密
            String digest = EncoderHandler.encode("SHA1", bigStr).toLowerCase();
            // 确认请求来至微信
            if (digest.equals(signature)) {
                // 最好此处将echostr存起来，以后每次校验消息来源都需要用到
                return echostr;
            }
        }
        return "error";
    }
}
