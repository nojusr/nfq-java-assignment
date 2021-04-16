package ml.kelp.nfq.assignment.main.service;

import ml.kelp.nfq.assignment.main.entity.Reservation;
import ml.kelp.nfq.assignment.main.entity.Specialist;
import ml.kelp.nfq.assignment.main.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialistAppointmentTimeService {

    @Autowired
    ReservationRepository reservationRepository;

    // could be optimized
    public double getAverageAppointmentTimeOfSpecialist(Specialist specialist, int limit) {

        // using repository here because the specialist might be coming from Reservation.getSpecialist() and therefore
        // the specialist might have their reservations set to null in order to avoid circular references
        List<Reservation> reservations = reservationRepository.findBySpecialistOrderByTimeAddedDesc(specialist);

        int amountAveraged = 0;
        Long sum = 0L;

        for (Reservation res : reservations) {
            Long startTime = res.getTimeStarted();
            Long endTime = res.getTimeEnded();

            if (startTime == null || endTime == null) {
                continue;
            }
            amountAveraged++;
            Long timeSpent = endTime-startTime;
            sum += timeSpent;

            if (amountAveraged >= limit) {
                break;
            }
        }

        if (amountAveraged == 0) {
            return 0;
        } else {
            return (double) sum / (double) amountAveraged;
        }
    }
}
