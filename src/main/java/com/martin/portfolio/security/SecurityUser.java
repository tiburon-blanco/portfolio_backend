package com.martin.portfolio.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class SecurityUser extends User {
    
	private static final long serialVersionUID = 5681144320867424802L;

	private long id;

	private String email;

    public SecurityUser(String email, String password, Collection<? extends GrantedAuthority> authorities, long id ) {
        super(email, password, authorities);
        this.setId(id);
		this.setEmail(email);
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }
}
