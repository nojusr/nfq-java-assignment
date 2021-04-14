package ml.kelp.nfq.assignment.main.service;

import ml.kelp.nfq.assignment.main.entity.Specialist;
import ml.kelp.nfq.assignment.main.repository.SpecialistRepository;
import ml.kelp.nfq.assignment.main.utils.SpecialistUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class SpecialistDetailsService implements UserDetailsService {

    @Autowired
    private SpecialistRepository specialistRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Specialist spec = specialistRepository.findByEmail(email);
        if (spec == null) {
            throw new UsernameNotFoundException(email);
        }
        return new SpecialistUserDetails(spec);
    }
}


