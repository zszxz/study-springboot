package com.youku1327.sockets.controller;

import com.youku1327.sockets.entity.AcceptMessages;
import com.youku1327.sockets.entity.SendMessages;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @Author lsc
 * @Description <p>websockets 之 广播式</p>
 * @Date 2019/11/12 22:49
 */
@Controller
public class WebSocketsController {

    @MessageMapping("/welcome")//类似@RequestMapping，进行客户端请求地址映射
    @SendTo("/topic/getResponse")//订阅了@SendTo中的路径进行发送消息
    public SendMessages broadcast(AcceptMessages acceptMessages){
        System.out.println(acceptMessages.getName());
        SendMessages sendMessages = new SendMessages();
        sendMessages.setResponseMessage("知识追寻者:"+acceptMessages.getName());
        return sendMessages;
    }

 /*   @RequestMapping(value="/ws")
    public String broadcastIndex(HttpServletRequest req){
        System.out.println(req.getRemoteHost());
        return "WebSockets";
    }*/


}
