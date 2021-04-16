package ml.kelp.nfq.assignment.main.controller;

import ml.kelp.nfq.assignment.main.entity.Reservation;
import ml.kelp.nfq.assignment.main.repository.ReservationRepository;
import ml.kelp.nfq.assignment.main.service.ReservationQueueCountService;
import ml.kelp.nfq.assignment.main.service.SpecialistAppointmentTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

// controller that allows user to view and edit a single reservation
@Controller
public class ReservationViewController {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    SpecialistAppointmentTimeService timeService;

    @Autowired
    ReservationQueueCountService queueCountService;

    @RequestMapping("/reservation/view/{secret}")
    public String viewReservation(@PathVariable String secret, Model model) {
        Reservation res = reservationRepository.findByCustomerSecret(secret);
        if (res == null) {
            return "reservationNotFound";
        }

        model.addAttribute("reservation", res);
        return "reservationView";
    }

    //TODO: test if this would work by replacing Map<String, String> with Map<String, Object>
    @GetMapping("/reservation/view/{secret}/info")
    @ResponseBody
    public Map<String, String> getLiveReservationInfo(@PathVariable String secret) {
        HashMap<String, String> output = new HashMap<>();

        Reservation res = reservationRepository.findByCustomerSecret(secret);
        if (res == null) {
            return null;
        }

        int queueNum = queueCountService.getReservationQueueNumber(res);
        double averageWaitTime = timeService.getAverageAppointmentTimeOfSpecialist(res.getSpecialist(), 10);

        double estWaitTimeSeconds = averageWaitTime*(double)queueNum;

        output.put("queueNum", String.valueOf(queueNum));
        output.put("avgTime", String.valueOf(averageWaitTime));
        output.put("estWaitTime", String.valueOf(estWaitTimeSeconds));
        return output;
    }
}
