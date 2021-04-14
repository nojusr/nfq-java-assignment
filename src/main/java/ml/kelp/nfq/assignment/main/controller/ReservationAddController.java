package ml.kelp.nfq.assignment.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// reservation add page controller -- used for adding reservations
// user should be able to: select reservation, select specialist, enter their name,
@Controller
public class ReservationAddController {

    @GetMapping(value = "/reservation/add")
    public String reservationAddGet() {
        return "reservationAdd";
    }

    @PostMapping(value = "/reservation/add")
    public String reservationAddPost() {
        return "reservationView";
    }

}
