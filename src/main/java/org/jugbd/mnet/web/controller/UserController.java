package org.jugbd.mnet.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Bazlur Rahman Rokon on 6/24/14.
 */
@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Secured("user")
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        log.debug("index page");

        return "user/index";
    }
}
