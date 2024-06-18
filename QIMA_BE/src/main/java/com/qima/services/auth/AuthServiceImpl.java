package com.qima.services.auth;

import com.qima.dto.SignupDTO;
import com.qima.dto.LoginDTO;
import com.qima.entities.Login;
import com.qima.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public LoginDTO createUser(SignupDTO signupDTO) {
        Login user = new Login();
        user.setName(signupDTO.getName());
        user.setEmail(signupDTO.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
        Login createdUser = loginRepository.save(user);
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setId(createdUser.getId());
        loginDTO.setEmail(createdUser.getEmail());
        loginDTO.setName(createdUser.getName());
        return loginDTO;
    }
}
