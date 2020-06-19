package com.cts.fms.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.fms.user.dao.JwtUserDao;
import com.cts.fms.user.dao.UserDao;
import com.cts.fms.user.model.DAOUser;
import com.cts.fms.user.model.UserDTO;
import com.cts.fms.user.model.UserDTOUpdate;

@Service
public class JwtUserDetailsService  implements UserDetailsService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private JwtUserDao jwtUserDao;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = jwtUserDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setEmployeeId(user.getEmployeeId());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setEmprole(user.getEmprole());
		newUser.setEmpStatus(user.getEmpStatus());
		newUser.setEmoplyeeName(user.getEmoplyeeName());
		return jwtUserDao.save(newUser);
	}
	public DAOUser getUSerDao(String username) {
	DAOUser user = jwtUserDao.findByUsername(username);
	return user;
	}
	
	public List<DAOUser> getAllUSer(){
		return jwtUserDao.findAll();
	}
	
	public DAOUser updateUser(UserDTOUpdate user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setEmployeeId(user.getEmployeeId());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setEmprole(user.getEmprole());
		newUser.setEmpStatus(user.getEmpStatus());
		newUser.setEmoplyeeName(user.getEmoplyeeName());
		newUser.setId(user.getId());
		return jwtUserDao.save(newUser);
	}

	public DAOUser deleteUser(Long id) {
		// TODO Auto-generated method stub
		jwtUserDao.deleteById(id);
		
		return jwtUserDao.findAllById(id);
	}
}

