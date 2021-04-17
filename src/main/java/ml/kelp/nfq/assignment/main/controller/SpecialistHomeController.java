package ml.kelp.nfq.assignment.main.controller;

import ml.kelp.nfq.assignment.main.entity.Reservation;
import ml.kelp.nfq.assignment.main.entity.Specialist;
import ml.kelp.nfq.assignment.main.repository.ReservationRepository;
import ml.kelp.nfq.assignment.main.service.ReservationQueueCountService;
import ml.kelp.nfq.assignment.main.utils.SpecialistUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

@Controller
public class SpecialistHomeController {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationQueueCountService queueCountService;

    // Not a good way to do this.
    // It would be better to instead provide a REST getter
    // for all reservations of specialist and handle it client-side,
    // since, at it's current state, the specialist cannot know if
    // they got a new client without refreshing the page.
    @RequestMapping("/home")
    public String specialistHome(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Specialist specialist = ((SpecialistUserDetails)auth.getPrincipal()).getSpecialist();

        // might need to access via repository
        List<Reservation> specialistReservations = reservationRepository.findBySpecialistOrderByTimeAddedDesc(specialist);

        specialistReservations.removeIf(res -> (res.isFinished()));

        for (Reservation res : specialistReservations) {
            res.setQueueNumber(queueCountService.getReservationQueueNumber(res));
        }

        model.addAttribute("reservations", specialistReservations);
        return "specialistHome";
    }

    @RequestMapping("/home/start/{id}")
    public RedirectView specialistStartAppointment(@PathVariable(name="id") Long reservationID) {

        long currentUnixTime = System.currentTimeMillis() / 1000L;

        Reservation res = reservationRepository.findOneById(reservationID);
        res.setTimeStarted(currentUnixTime);
        res.setIsVisiting(true);
        reservationRepository.saveAndFlush(res);

        return new RedirectView("/home");
    }


    @RequestMapping("/home/finish/{id}")
    public RedirectView specialistEndAppointment(@PathVariable(name="id") Long reservationID) {
        long currentUnixTime = System.currentTimeMillis() / 1000L;

        Reservation res = reservationRepository.findOneById(reservationID);
        res.setTimeEnded(currentUnixTime);
        res.setIsVisiting(false);
        res.setFinished(true);
        reservationRepository.saveAndFlush(res);
        return new RedirectView("/home");
    }

    @RequestMapping("/home/cancel/{id}")
    public RedirectView specialistCancelAppointment(@PathVariable(name="id") Long reservationID) {
        long currentUnixTime = System.currentTimeMillis() / 1000L;
        Reservation res = reservationRepository.findOneById(reservationID);

        if(res.getIsVisiting() == true) {
            res.setIsVisiting(false);

        }
        res.setFinished(true);
        reservationRepository.saveAndFlush(res);
        return new RedirectView("/home");
    }

}
