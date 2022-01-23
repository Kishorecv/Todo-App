package com.rest.webservices.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "Kishore",
        "$2a$10$p5ZlNPQ1xZslbiZYcMHDHuTPNx8XA8WWk8bZ.DqxnpBEEV4VvK1IC", "ROLE_USER_2"));
    inMemoryUserList.add(new JwtUserDetails(2L, "nithya",
            "$2a$10$kMa6ml6K2MF3A5OJiPg7pOrS2.fQ2dfcIRYB7rDVzJzyft3Hj7s7.", "ROLE_USER_2"));
    //$2a$10$kMa6ml6K2MF3A5OJiPg7pOrS2.fQ2dfcIRYB7rDVzJzyft3Hj7s7.
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


