package com.liutf.mvc.controller;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @description: HttpSession监听器
 * @author: liutf
 * @date: 2015年3月5日 下午5:50:05
 * @version: V1.0.0
 */
public class SessionListener implements HttpSessionListener,
		HttpSessionAttributeListener {

	// 保存当前登录的所有用户
	public static Map<HttpSession, String> loginUser = new HashMap<HttpSession, String>();

	// 用这个作为session中的key
	public static final String CURRENT_KEY_USER = "currentUser";
	public static final String CURRENT_KEY_DOCTOR = "currentDoctor";

	/**
	 * @description: session创建时调用这个方法
	 * @param arg0
	 * @author: liutf
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 * @date: 2015年3月5日 下午5:50:26
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		// System.out.println("session创建了");
	}

	/**
	 * @description: Session失效或者过期的时候调用的这个方法
	 * @param se
	 * @author: liutf
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 * @date: 2015年3月5日 下午5:50:46
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		// 如果session超时, 则从map中移除这个用户
		try {
			loginUser.remove(se.getSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @description: 执行setAttribute的时候, 当这个属性本来不存在于Session中时, 调用这个方法.
	 * @param se
	 * @author: liutf
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.servlet.http.HttpSessionBindingEvent)
	 * @date: 2015年3月5日 下午5:50:58
	 */
	public void attributeAdded(HttpSessionBindingEvent se) {
		// 如果添加的属性是用户名, 则加入map中
		
	}

	/**
	 * @description: 当执行removeAttribute时调用的方法
	 * @param se
	 * @author: liutf
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax.servlet.http.HttpSessionBindingEvent)
	 * @date: 2015年3月5日 下午5:51:13
	 */
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// 如果移除的属性是用户名, 则从map中移除
		if (se.getName().equals(CURRENT_KEY_USER)
				|| se.getName().equals(CURRENT_KEY_DOCTOR)) {
			try {
				loginUser.remove(se.getSession());
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @description: 当执行setAttribute时 ,如果这个属性已经存在, 覆盖属性的时候, 调用这个方法
	 * @param se
	 * @author: liutf
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax.servlet.http.HttpSessionBindingEvent)
	 * @date: 2015年3月5日 下午5:51:29
	 */
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// 如果改变的属性是用户名, 则跟着改变map
		
	}

	/**
	 * @description: 判断用户是否已经登录
	 * @param name
	 * @return
	 * @author: liutf
	 * @date: 2015年3月5日 下午5:51:40
	 */
	public static boolean isLogonUser(String name) {
		Set<HttpSession> keys = SessionListener.loginUser.keySet();
		for (HttpSession key : keys) {
			if (SessionListener.loginUser.get(key).equals(name)) {
				return true;
			}
		}
		return false;
	}
}