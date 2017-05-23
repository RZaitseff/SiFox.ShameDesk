package com.sifox.service;

import java.util.*;

/*
 * @Author Roman Zaytsev
 * @Date 18.05.2017
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sifox.dao.UserDAO;
import com.sifox.entity.User;

@Service
public class UserService  implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserDAO userDAO;
	
	public User read(int id) {
        return userDAO.findById(id);
	}

	public User read(String userName) {
        return userDAO.read("login", userName);
	}

	public List<User> list() {
		return userDAO.list();
	}

    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        User user = userDAO.read("login", userLogin);
        if (user != null) {
            Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("user with login '" + userLogin + "' not found");
        }
    }

}
