package ml.kelp.nfq.assignment.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// controller that allows user to view and edit a single reservation
@Controller
public class ReservationViewController {

    @RequestMapping("/reservation/view")
    public String viewReservation() {
        return "temp";
    }
}
