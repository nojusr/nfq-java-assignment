package ml.kelp.nfq.assignment.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// reservation add page controller -- used for adding reservations
// user should be able to: select reservation, enter their name,
@Controller
public class ReservationAddController {

    @RequestMapping(value = "/reservation/add")
    public String reservationAdd() {
        return "temp";
    }
}
