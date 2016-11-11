package com.liutf.mvc.entity;

/**
 * @description: TODO
 * @author: liutf
 * @date: 2015年4月2日 上午11:36:47
 * @version: V1.0.0
 */
public class CheckModel extends ErrorCodeModel {
    String signature;
    Long timestamp;
    Long nonce;
    String echostr;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getNonce() {
        return nonce;
    }

    public void setNonce(Long nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }
}
