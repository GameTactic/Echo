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
import com.gametactic.echo.model.EchoMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
public final class EchoController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public EchoMessage sendMessage(@Payload EchoMessage echoMessage) {
        return echoMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public EchoMessage addUser(@Payload EchoMessage echoMessage, SimpMessageHeaderAccessor headerAccessor) {
        Objects.requireNonNull(headerAccessor.getSessionAttributes()).put(AbstractMessage.SENDER_FIELD, "niko");

        return echoMessage;
    }
}
