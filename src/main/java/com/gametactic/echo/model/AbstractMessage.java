/*
 * GameTactic — NOTICE OF LICENSE
 *
 * This source file is released GPLv3 license by copyright holders.
 * Please see LICENSE file for more specific licensing terms.
 * @copyright 2019-2019 (c) GameTactic
 * @author Niko Granö <niko@granö.fi>
 */

package com.gametactic.echo.model;

public abstract class AbstractMessage {
    public static final String SENDER_FIELD = "username";

    private String sender;
    private String message;

    public AbstractMessage(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }
}
