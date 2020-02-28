package com.zszxz.jwt.interceptor;

import com.zszxz.jwt.service.SysUserService;
import com.zszxz.jwt.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author lsc
 * <p>token验证拦截器 </p>
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    SysUserService sysUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从 http 请求头中取出 token
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        if (token != null){
            String username = JwtUtil.getUserNameByToken(request);
            // 这边拿到的 用户名 应该去数据库查询获得密码，简略，步骤在service直接获取密码
            boolean result = JwtUtil.verify(token,username,sysUserService.getPassword());
            if(result){
                System.out.println("通过拦截器");
                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
