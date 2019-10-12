/*
 * GameTactic — NOTICE OF LICENSE
 *
 * This source file is released GPLv3 license by copyright holders.
 * Please see LICENSE file for more specific licensing terms.
 * @copyright 2019-2019 (c) GameTactic
 * @author Niko Granö <niko@granö.fi>
 */

package com.gametactic.echo.controller;

import com.gametactic.echo.model.AbstractMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public final class WebSocketEventListener {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations messageTemplate;

    @EventListener
    public void handleWebsocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String user = (String) headerAccessor.getSessionAttributes().get(AbstractMessage.SENDER_FIELD);
        if (user != null) {
            logger.info(String.format("User %s disconnected.", user));
        }
    }
}
