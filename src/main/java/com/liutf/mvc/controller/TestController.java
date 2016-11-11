package com.liutf.mvc.controller;

import com.liutf.mvc.utils.ToJson;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liutf
 */
@RequestMapping("/test")
public class TestController {

    /**
     * 此种方法级别定义测试通不过
     *
     * @return
     * @author liutf
     */
    @RequestMapping("/doTest")
    @ResponseBody
    public ToJson doTest(@Param("value") String value,
                         HttpServletRequest request) {

        HttpSession session = request.getSession();

        System.out.println("session.key---" + session.getAttribute("key"));

        System.out.println("sessionId-->" + session.getId());

        session.setAttribute("key", "value");

        ToJson json = new ToJson();
        json.setRtMsg("测试成功!");
        json.setRtData(value);
        return json;
    }

    /**
     * @param value
     * @return
     * @description: 测试http请求，方法级别后以.do结尾
     * @author: xg.zhang
     * @date: 2015年2月6日 上午9:56:35
     */

    @RequestMapping("/test.do")
    @ResponseBody
    public ToJson Test(@Param("value") String value) {
        ToJson json = new ToJson();
        json.setRtMsg("Test测试成功!");
        json.setRtData(value);
        return json;
    }

    @RequestMapping("/test2.do")
    @ResponseBody
    public ToJson test2(Bean bean) {
        ToJson json = new ToJson();
        json.setRtMsg("Test测试成功!");
        json.setRtData(bean.getDate());
        Date d = bean.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.format(d);
        System.out.println("------date------" + sdf.format(d) + "-------");
        return json;
    }

    /**
     * 测试客户端请求服务端页面
     *
     * @param value
     * @return
     * @description: TODO
     * @author: liutf
     * @date: 2015年2月11日 上午11:14:35
     */
    @RequestMapping("/testForHtml.do")
    public ModelAndView testForHtml(@Param("value") String value) {
        ModelAndView mav = new ModelAndView("/index");
        mav.addObject("value", value);
        return mav;
    }

}

class Bean {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
