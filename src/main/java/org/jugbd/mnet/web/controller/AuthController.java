package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.User;
import org.jugbd.mnet.service.UserService;
import org.jugbd.mnet.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.Principal;

/**
 * Created by Bazlur Rahman Rokon on 7/4/14.
 */
@Controller
public class AuthController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    // Login form
    @RequestMapping("/login")
    public String login() {
        log.debug("login()");

        return "login";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        log.debug("loginError()");

        model.addAttribute("loginError", true);
        return "login";
    }
}
