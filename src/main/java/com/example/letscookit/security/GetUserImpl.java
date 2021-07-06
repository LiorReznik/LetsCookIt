package com.example.letscookit.security;

import com.example.letscookit.users.business.User;
import com.example.letscookit.users.business.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class GetUserImpl implements GetUser {
    @Override
    public User getUser() {
        UserDetailsImpl u = (UserDetailsImpl) SecurityContextHolder.getContext().
                getAuthentication().getPrincipal();
        return u.getUser();
    }
}
