package org.jugbd.mnet.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Bazlur Rahman Rokon on 6/24/14.
 */
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('admin')")
public class AdminController {
    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        log.debug("index page");

        return "admin/index";
    }
}
