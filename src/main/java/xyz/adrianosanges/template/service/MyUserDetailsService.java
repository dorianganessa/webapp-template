package xyz.adrianosanges.template.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.adrianosanges.template.dao.UtenteDao;
import xyz.adrianosanges.template.model.UserRole;
import xyz.adrianosanges.template.model.Utente;
 
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
 
	//get user from the database, via Hibernate
	@Autowired
	private UtenteDao userDao;
 
	@Transactional(readOnly=true)
	public Utente loadUserByUsername(String username)	throws UsernameNotFoundException {
 
		Utente user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
 
		return buildUserForAuthentication(user, authorities);
 
	}
 
	// Converte il model user in un
	// org.springframework.security.core.userdetails.User
	private Utente buildUserForAuthentication(Utente user, List<GrantedAuthority> authorities) {
		return new Utente(user.getUsername(), user.getPassword(),true, true, true, true, authorities);
	}
 
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
 
		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
 
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
 
		return Result;
	}
 
}
