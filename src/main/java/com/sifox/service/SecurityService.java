package com.sifox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sifox.entity.User;

/**
 * TODO: Javadoc for com.sifox.service
 *
 * @author Oleg Korolyov (o.korolyov@ameria.de)
 */
@Service
public class SecurityService 
{
    @Autowired
    private UserService userService;
    
    @Autowired
	UserDetailsService userDetailsService;

    public User getCurrentUser() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.read(userName);
    }
    
    public Boolean authenticateRegisteredUser(String userName) {
		UserDetails detail = userDetailsService.loadUserByUsername(userName); 
		Authentication auth = new UsernamePasswordAuthenticationToken(detail, detail.getPassword(), detail.getAuthorities());

        SecurityContext sc = new SecurityContextImpl();

        ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        attr.getRequest().getSession().setAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, detail.getUsername());

        sc.setAuthentication(auth);
        SecurityContextHolder.setContext(sc);

        return true;
	}
    
}
