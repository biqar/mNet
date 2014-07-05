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
 * Created by Bazlur Rahman Rokon on 7/6/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(params = "form", method = RequestMethod.GET, produces = "text/html")
    public String createForm(Model uiModel) {
        log.debug("createForm()");

        populateEditForm(uiModel, new User());
        return "user/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid User user, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest, Principal principal) {

        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, user);
            return "user/create";
        }

        uiModel.asMap().clear();

        try {
            User currentUser = userService.findByUserName(principal.getName());
            Utils.updatePersistentProperties(user, currentUser);
            userService.create(user);
            return "redirect:/user/show" + encodeUrlPathSegment(user.getId().toString(), httpServletRequest);
        } catch (Exception e) {
            uiModel.addAttribute("error", "Unable to save user");
            return "user/create";
        }
    }

    @RequestMapping(value = "{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("user", userService.findById(id));
        uiModel.addAttribute("itemId", id);
        return "user/show";
    }

    private void populateEditForm(Model uiModel, User newUser) {
        uiModel.addAttribute("newUser", newUser);
    }

    String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException ignored) {
        }
        return pathSegment;
    }
}
