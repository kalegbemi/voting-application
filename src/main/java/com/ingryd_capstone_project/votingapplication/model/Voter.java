package com.ingryd_capstone_project.votingapplication.model;

import com.ingryd_capstone_project.votingapplication.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "voter_table")
public class Voter implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade =CascadeType.ALL)
    private Vote vote;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role = Role.VOTER;

    public String setPassword() {
        return setPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
    @Override
    public String getUsername() {
        return this.username;
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
