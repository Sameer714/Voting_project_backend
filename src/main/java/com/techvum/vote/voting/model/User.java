package com.techvum.vote.voting.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User implements UserDetails{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Id")
	private long id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Pass")
	private String pass;
	
	@Column(name="Role")
	private String role;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="Username")
	private String username;
	
	
	public User(long id, String name, String pass, String role, String email, String status, String username) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.role = role;
		this.email = email;
		this.status = status;
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass + ", role=" + role + ", email=" + email
				+ ", status=" + status + ", username=" + username + "]";
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public User() {
		super();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> listRole = new ArrayList<GrantedAuthority>();
		listRole.add(new SimpleGrantedAuthority(this.role));
		return listRole;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		if (pass.isEmpty() || username.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isEnabled() {
		if (pass.isEmpty() || username.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String getPassword() {
		return null;
	}
}
