package com.example.recipesapi.security;


import com.example.recipesapi.entity.User;
import com.example.recipesapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private UserService userService;
	

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		Optional<User> userOptional = userService.findById(Long.parseLong(id));
		if (userOptional.isPresent()) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			User user = userOptional.get();
			authorities.add(new SimpleGrantedAuthority(user.isAdmin() ? "ROLE_ADMIN": "ROLE_USER"));


			return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(),
					authorities);
		} else {
			throw new UsernameNotFoundException("User not found with id: " + id);
		}
	}
}