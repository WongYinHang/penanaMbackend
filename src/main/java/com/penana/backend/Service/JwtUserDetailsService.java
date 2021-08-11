package com.penana.backend.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.penana.backend.Dao.userRepostory;
import com.penana.backend.Model.user;
import com.penana.backend.Model.userDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private userRepostory userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = new ArrayList<>();
		user user = userDao.findByemail(email);

		if (user != null) {
			System.out.println("email: " + user.getEmail());
			System.out.println("userRole: " + user.getRole());
			roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
			return new User(user.getEmail(), user.getPassword(), roles);
		}
		throw new UsernameNotFoundException("User not found with the email " + email);
	}

	public Boolean checkpassword(String email, String password) {
		user user = userDao.findByemail(email);
		Boolean correctPassword = bcryptEncoder.matches(password, user.getPassword());
		return correctPassword;
	}

	public user save(userDTO user) throws UsernameNotFoundException {
		String email = (String) user.getemail();
		user Checkemail = userDao.findByemail(email);
		if (Checkemail == null) {

			user newUser = new user();
			newUser.setEmail(email);
			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			newUser.setRole(user.getRole());

			System.out.println(newUser);
			return userDao.save(newUser);
		}
		throw new UsernameNotFoundException("Email " + user.getemail() + " has been registered ");
	}

}