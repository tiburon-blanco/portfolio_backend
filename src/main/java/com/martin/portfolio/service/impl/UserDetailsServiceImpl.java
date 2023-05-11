package com.martin.portfolio.service.impl;

import com.martin.portfolio.entity.Usuario;
import com.martin.portfolio.repository.UsuarioRepository;
import com.martin.portfolio.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  UsuarioRepository usuarioRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario user = usuarioRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return new SecurityUser(user.getEmail(), user.getPassword(), new ArrayList<>(), user.getId());
  }

}
