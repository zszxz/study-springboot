package com.zszxz.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class SpringContextUtils implements ApplicationContextAware {

	/* *
	 * @Author lsc
	 * <p> 获取上下文实例</p>
	 * @Param
	 * @Return
	 */
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtils.applicationContext = applicationContext;
	}

	/**
	 * 获取applicationContext
	 *
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	  * 获取HttpServletRequest
	 */
	public static HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/* *
	 * @Author lsc
	 * <p> 获得域名 </p>
	 * @Param []
	 * @Return java.lang.String
	 */
	public static String getDomain(){
		HttpServletRequest request = getHttpServletRequest();
		StringBuffer url = request.getRequestURL();
		return url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
	}

	/* *
	 * @Author lsc
	 * <p> 获取源</p>
	 * @Param []
	 * @Return java.lang.String
	 */
	public static String getOrigin(){
		HttpServletRequest request = getHttpServletRequest();
		return request.getHeader("Origin");
	}
	
	/* *
	 * @Author lsc
	 * <p>通过name获取 Bean </p>
	 * @Param [name]
	 * @Return java.lang.Object
	 */
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	/* *
	 * @Author lsc
	 * <p> 通过class获取Bean</p>
	 * @Param [clazz]
	 * @Return T
	 */
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	/* *
	 * @Author lsc
	 * <p> 通过name,以及Clazz返回指定的Bean </p>
	 * @Param [name, clazz]
	 * @Return T
	 */
	public static <T> T getBean(String name, Class<T> clazz) {
		return getApplicationContext().getBean(name, clazz);
	}
}
