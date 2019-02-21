package com.Briantpt30.TaskProject.Service;

import org.springframework.stereotype.Service;

@Service
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
