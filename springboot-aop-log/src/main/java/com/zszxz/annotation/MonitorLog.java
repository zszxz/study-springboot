package com.zszxz.annotation;


import com.zszxz.eu.LogEnum;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MonitorLog {

    /* *
     * @Author lsc
     * <p>日志内容 </p>
     * @Param []
     * @Return java.lang.String
     */
    String value() default "";

    /* *
     * @Author lsc
     * <p>日志操作类型 </p>
     * @Param []
     * @Return int
     */
    LogEnum operateType() default LogEnum.UNOPERATE;


}
