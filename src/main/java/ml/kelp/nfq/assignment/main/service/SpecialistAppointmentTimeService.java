package ml.kelp.nfq.assignment.main.service;

import ml.kelp.nfq.assignment.main.entity.Reservation;
import ml.kelp.nfq.assignment.main.entity.Specialist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialistAppointmentTimeService {
    // could be optimized
    public double getAverageAppointmentTimeOfSpecialist(Specialist specialist, int limit) {
        List<Reservation> reservations = specialist.getReservations();

        int amountAveraged = 0;
        Long sum = 0L;

        for (Reservation res : reservations) {
            Long startTime = res.getTimeStarted();
            Long endTime = res.getTimeEnded();

            if (startTime == null && endTime == null) {
                continue;
            }
            amountAveraged++;
            Long timeSpent = endTime-startTime;
            sum += timeSpent;

            if (amountAveraged >= limit) {
                break;
            }
        }
        return (double)sum/(double)amountAveraged;
    }
}
