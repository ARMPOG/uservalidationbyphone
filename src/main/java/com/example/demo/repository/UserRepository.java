package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByPhone(String phone);

    User findByPhone(String phone);

    User findByPhoneAndVerifyCode(String phone, String verifyCode);

    @Modifying
    @Transactional
    @Query(value = "update User u set u.verifyCode=null where u.phone=:phoneNumber")
    void updateUserVerifyCodeByPhoneNumber(@Param("phoneNumber") String phone);
}
