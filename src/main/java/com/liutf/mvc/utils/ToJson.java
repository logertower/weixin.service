package com.liutf.mvc.utils;

public class ToJson {

    // private boolean rtState;// 操作信息
    private String rtCode;// 错误代码
    private String jsessionid;
    private String rtMsg;// 消息
    private Object rtData;// 值
    private String againRequest;// 是否再次发送请求 0-否，1-是

    public ToJson() {
        this.againRequest = "0";
    }

    public String getRtCode() {
        return rtCode;
    }

    public void setRtCode(String rtCode) {
        this.rtCode = rtCode;
    }

    public String getJsessionid() {
        return jsessionid;
    }

    public void setJsessionid(String jsessionid) {
        this.jsessionid = jsessionid;
    }

    public String getRtMsg() {
        return rtMsg;
    }

    public void setRtMsg(String rtMsg) {
        this.rtMsg = rtMsg;
    }

    public Object getRtData() {
        return rtData;
    }

    public void setRtData(Object rtData) {
        this.rtData = rtData;
    }

    public String getAgainRequest() {
        return againRequest;
    }

    public void setAgainRequest(String againRequest) {
        this.againRequest = againRequest;
    }

}
