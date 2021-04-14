package ml.kelp.nfq.assignment.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value="/signup")
    public String signup(){
        return "signup";
    }
}
