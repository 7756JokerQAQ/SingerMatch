package com.yupi.yupao.config;

import com.yupi.yupao.common.ErrorCode;
import com.yupi.yupao.exception.BusinessException;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * @author LYC
 */
public class HttpSessionConfigurator extends ServerEndpointConfig.Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        if (httpSession == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN);
        }
        //将httpSession保存起来
        sec.getUserProperties().put(HttpSession.class.getName(), httpSession);
    }
}
