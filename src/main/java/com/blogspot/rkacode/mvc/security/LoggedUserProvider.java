package com.blogspot.rkacode.mvc.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface LoggedUserProvider {

    UserDetails getLoggedUser();

}
