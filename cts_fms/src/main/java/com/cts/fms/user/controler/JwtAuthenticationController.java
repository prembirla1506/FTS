package com.cts.fms.user.controler;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.fms.config.JwtTokenUtil;
import com.cts.fms.user.model.DAOUser;
import com.cts.fms.user.model.JwtRequest;
import com.cts.fms.user.model.JwtResponse;
import com.cts.fms.user.model.UserDTO;
import com.cts.fms.user.model.UserDTOUpdate;

import com.cts.fms.user.model.UserResponse;
import com.cts.fms.user.service.JwtUserDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:8088")

public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final DAOUser user = userDetailsService.getUSerDao(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token, user));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUser() throws Exception {
		List<DAOUser> users = userDetailsService.getAllUSer();

		UserResponse userRes = new UserResponse();

		userRes.setUsers(users);

		return ResponseEntity.ok(userRes);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ResponseEntity<?> updateUSer(@RequestBody UserDTOUpdate user) throws Exception {
		return ResponseEntity.ok(userDetailsService.updateUser(user));
	}

	@RequestMapping(value = "/deleteusers", method = RequestMethod.GET)
	public ResponseEntity<?> updateUSer(@RequestParam("id") Long id) throws Exception {
		return ResponseEntity.ok(userDetailsService.deleteUser(id));
	}
}
