package ml.kelp.nfq.assignment.main.utils;

import ml.kelp.nfq.assignment.main.entity.Role;
import ml.kelp.nfq.assignment.main.entity.Specialist;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class SpecialistUserDetails implements UserDetails {
    private Specialist specialist;

    public SpecialistUserDetails(Specialist specialist) {
        this.specialist = specialist;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = specialist.getRoles();

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return specialist.getPassword();
    }

    @Override
    public String getUsername() {
        return specialist.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return specialist.isEnabled();
    }
}
