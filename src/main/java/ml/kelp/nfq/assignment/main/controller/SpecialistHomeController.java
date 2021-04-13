package ml.kelp.nfq.assignment.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpecialistHomeController {

    @RequestMapping("/home")
    public String specialistHome() {
        return "temp";
    }

}
