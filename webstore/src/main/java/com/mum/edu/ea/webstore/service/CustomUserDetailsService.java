package com.mum.edu.ea.webstore.service;

import com.mum.edu.ea.webstore.config.UserAdapter;
import com.mum.edu.ea.webstore.dao.UserRepository;
import com.mum.edu.ea.webstore.entity.Person;
import com.mum.edu.ea.webstore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PersonService personService;

	public CustomUserDetailsService() {
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User with %s doesn't exist!", email));
		}
		List<Person> persons = personService.findByEmail(user.getEmail());
		return new UserAdapter(user, persons.get(0));
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}
}
