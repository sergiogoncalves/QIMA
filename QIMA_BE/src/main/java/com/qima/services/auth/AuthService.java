package com.qima.services.auth;

import com.qima.dto.SignupDTO;
import com.qima.dto.LoginDTO;

public interface AuthService {
    LoginDTO createUser(SignupDTO signupDTO);
}
