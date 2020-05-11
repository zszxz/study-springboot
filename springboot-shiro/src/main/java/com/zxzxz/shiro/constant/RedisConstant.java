package com.zxzxz.shiro.constant;

/*
 * @Author lsc
 * @Description <p>常量配置 </p>
 * @Date  2019/11/18 16:19
 * @Param
 * @Return
 */
public interface RedisConstant {
    // 可以添加tocken 前缀
    String PREFIX_LOGIN = "zxzxz_%s";
    // 过期时间2小时
    Integer REDIS_EXPIRE_TWO = 7200;
    // 过期时间15分
    Integer REDIS_EXPIRE_EMAIL = 900;
     // 过期时间6分钟
    Integer EXPIRE_KAPTCHA = 600;
    // 暂无过期时间
    Integer EXPIRE_NULL = -1;
}
