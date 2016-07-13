package ca.isimtl.myPortal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        return "welcome";
    }

}
