package com.book.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Vlad Lukjanenko.
 */
@Controller
public class MainController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView getIndexPage() {
        return new ModelAndView("index");
    }
}
