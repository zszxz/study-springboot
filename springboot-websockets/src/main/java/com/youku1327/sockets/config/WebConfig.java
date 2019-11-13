package com.youku1327.sockets.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Author lsc
 * @Description <p>websocket配置类 </p>
 * @Date 2019/11/12 22:27
 */
//使用STOMP协议来传输基于消息代理的消息，控制器支持在@Controller类中使用@MessageMapping
@EnableWebSocketMessageBroker
@Configurable
@EnableWebSocket
@Component
public class WebConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册 Stomp的端点（Endpoint），并且映射指定的url
        registry.addEndpoint("/websocket")
                .setAllowedOrigins("*") // 添加允许跨域访问
                .withSockJS();// 指定SockJS协议
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 启动广播模式代理，只有符合的的路径才发送消息
        registry.enableSimpleBroker("/topic");
    }
}
