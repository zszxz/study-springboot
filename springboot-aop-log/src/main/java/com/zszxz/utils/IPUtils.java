package com.zszxz.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/* *
 * @Author lsc
 * <p>IP地址 </p>
 * @Param
 * @Return
 */
public class IPUtils {
	private static Logger logger = LoggerFactory.getLogger(IPUtils.class);

    public static String getIpAddress(HttpServletRequest request) {
        // 代理ip，第一个为真实
        String ip = request.getHeader("x-forwarded-for");
        // apache http 代理服务器
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        // nginx代理
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        // 获取客户端ip
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.contains(",")) {
            return ip.split(",")[0];
        } else {
            return ip;
        }
    }


	
}
