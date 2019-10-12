/*
 * GameTactic — NOTICE OF LICENSE
 *
 * This source file is released GPLv3 license by copyright holders.
 * Please see LICENSE file for more specific licensing terms.
 * @copyright 2019-2019 (c) GameTactic
 * @author Niko Granö <niko@granö.fi>
 */

package com.gametactic.echo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
final public class HealthController {

    private static final String RESPONSE = "{\"state\": true}";

    @GetMapping(value = "/healthz", produces = MediaType.APPLICATION_JSON_VALUE)
    public String healthz() {
        return HealthController.RESPONSE;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String index() {
        return HealthController.RESPONSE;
    }
}
