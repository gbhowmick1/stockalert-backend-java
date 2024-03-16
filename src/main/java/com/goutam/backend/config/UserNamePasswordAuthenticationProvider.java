package com.goutam.backend.config;

import com.goutam.backend.Entity.Roles;
import com.goutam.backend.Entity.UserRole;
import com.goutam.backend.Entity.Users;
import com.goutam.backend.repository.UserRepository;
import com.goutam.backend.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserNamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        List<Users> user = userRepository.findByEmail(username);
        if (user.size() > 0) {
            if (passwordEncoder.matches(pwd, user.get(0).getPassword())) {
                List<String> allroles = getAllRolesOfUser(user.get(0).getId().intValue());

                return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(allroles));

//                return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(user.get(0).getAuthorities()));
//                return new UsernamePasswordAuthenticationToken(username, pwd);
            } else {
                throw new BadCredentialsException("Invalid password!");
            }
        }else {
            throw new BadCredentialsException("No user registered with this details!");
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String>  allroles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (String role : allroles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    private List<UserRole> getUserRoleById(Integer id) {
        return userRoleRepository.findByUserId(id);
    }

    private List<String> getAllRolesOfUser(Integer userid) {
        List<String> roles =  userRepository.findAllRolesByUserId(userid);
        System.out.println("roles.toString()");
        System.out.println(roles.toString());
        return roles;
    }

    @PostConstruct
    public void init() {
        List<String> roles =  userRepository.findAllRolesByUserId(50);
        System.out.println("roles.toString()");
        System.out.println(roles.toString());
    }

}

