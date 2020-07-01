package com.zszxz.utils;

import com.zszxz.response.CodeMsg;
import com.zszxz.response.GlobleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @Author lsc
 * <p> </p>
 */
@Component
public class TokenUtis {

    @Autowired
    RedisUtils redisUtils;

    // token 过期时间为30秒
    private final static Long TOKEN_EXPIRE = 30L;

    private final static String TOKEN_NAME = "token";
    /* *
     * @Author lsc
     * <p> 生成token 放入缓存</p>
     * @Param []
     */
    public String generateToken() {
        String uuid = UUID.randomUUID().toString();
        String token = DigestUtils.md5DigestAsHex(uuid.getBytes());
        redisUtils.set(TOKEN_NAME,token,TOKEN_EXPIRE);
        return token;
    }
    /* *
     * @Author lsc
     * <p> token 校验 </p>
     * @Param [request]
     */
    public boolean verifyToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_NAME);
        // header中不存在token
        if(StringUtils.isEmpty(token)) {
           // 抛出自定义异常
            System.out.println("token不存在");
            throw new GlobleException(CodeMsg.BAD_REQUEST);
        }
        // 缓存中不出在 
        if(!redisUtils.hasKey(TOKEN_NAME)) {
            // 抛出自定义异常
            System.out.println("token已经过期");
            throw new GlobleException(CodeMsg.BAD_REQUEST);
        }
        String cachToekn = (String)redisUtils.get(TOKEN_NAME);
        if (!token.equals(cachToekn)){
            // 抛出自定义异常
            System.out.println("token校验失败");
            throw new GlobleException(CodeMsg.BAD_REQUEST);
        }
        // 移除token
        redisUtils.del(TOKEN_NAME);
        return true;
    }
}
