
package com.finalproject.finalproject.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalproject.finalproject.domain.Accounts;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.finalproject.finalproject.domain.Role;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class AwesomeUserDetails implements UserDetails {

    private String email;
    @JsonIgnore
    private String password;
    private List<Role> roles;

    public AwesomeUserDetails(Accounts user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
        return true;
    }
}