package com.smhrd.ttok.service;

import java.time.LocalDate;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smhrd.ttok.DTO.UserDTO;


import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class UserServiceTests {

    @Autowired
    private UserService userService;
    // 손승아, 등록 기능 테스트, 20240319
    @Test
    public void testRegister(){

        UserDTO userDTO = UserDTO.builder()
        .user_phone("01012341234")
        .user_pw("테스트")
        .user_nick("테스트 닉네임")
        .user_birth("971223")
        .user_gender("F")
        .user_nation("한국")
        .join_dt(LocalDate.of(2024, 03, 19))
        .build();

        Long user_idx = userService.register(userDTO);
        log.info("user_idx : ", user_idx);
    }
    // 손승아, select 기능 테스트, 20240319
    @Test
    public void testGet(){

        Long user_idx = 1L;
        UserDTO userDTO = userService.get(user_idx);
        log.info(userDTO);
    }
}
