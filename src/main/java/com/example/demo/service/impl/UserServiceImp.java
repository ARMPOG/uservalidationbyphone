package com.example.demo.service.impl;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.twilio.TwilioServiceImpl;
import com.example.demo.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AppUtil appUtil;
    private TwilioServiceImpl twilioService;

    @Autowired
    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder,
                          AppUtil appUtil, TwilioServiceImpl twilioService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.appUtil = appUtil;
        this.twilioService = twilioService;
    }

    @Override
    public User saveUser(User user) {
        User savedUser = null;
        if (!userRepository.existsByPhone(user.getPhone())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            String verificationCode = appUtil.randomNumeric(5);
            user.setVerifyCode(verificationCode);
            savedUser = userRepository.save(user);
            twilioService.sendMessage(user.getPhone(), "Dear user your verification code in ARM-Project app is "
                    + verificationCode);
        }
        return savedUser;
    }

    @Override
    public User verifyAccount(User user) {
        User verifiedUser = userRepository.findByPhoneAndVerifyCode(user.getPhone(), user.getVerifyCode());
        if(verifiedUser!=null){
            userRepository.updateUserVerifyCodeByPhoneNumber(user.getPhone());
            verifiedUser.setVerifyCode(null);
        }
        return verifiedUser;
    }
}
