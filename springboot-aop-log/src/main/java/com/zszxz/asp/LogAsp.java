package com.zszxz.asp;

import com.zszxz.annotation.MonitorLog;
import com.zszxz.eu.LogEnum;
import com.zszxz.utils.IPUtils;
import com.zszxz.utils.SpringContextUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lsc
 * <p>日志aop切面 </p>
 */

@Aspect
@Component
public class LogAsp {

    /* *
     * @Author lsc
     * <p> 设置切点</p>
     * @Param []
     * @Return void
     */
    @Pointcut("@annotation(com.zszxz.annotation.MonitorLog)")
    public void logPointCut() {

    }

    // 环绕通知
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        // 开始时间
        LocalDateTime beginTime = LocalDateTime.now();
        // 执行方法
        Object result = point.proceed();
        // 结束时间
        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(beginTime, endTime);
        // 操作时长
        long seconds = duration.getSeconds();
        // 保存日志
        saveLog(point,seconds);
        return result;
    }

    private void  saveLog(ProceedingJoinPoint point, long seconds){
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        // 获得注解
        MonitorLog monitorLog = method.getAnnotation(MonitorLog.class);
        if (monitorLog!=null){
            // 获得操作类型
            LogEnum operateType = monitorLog.operateType();
            // 获得操作内容
            String value = monitorLog.value();
            System.out.printf("获得操作类型: %s , 获得操作内容: %s ",operateType.getCode(),value);

            //请求的参数
            Object[] args = point.getArgs();
            try{
                List<Object> objects = Arrays.asList(args);
                System.out.println(objects);
            }catch (Exception e){

            }
            //获取request
            HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
            String ipAddr = IPUtils.getIpAddress(request);
            System.out.println(ipAddr);

        }
    }
}
