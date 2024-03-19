package com.smhrd.ttok.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smhrd.ttok.domain.User;

import lombok.extern.log4j.Log4j2;


@SpringBootTest
@Log4j2
public class UserRepositoryTests {
    
    @Autowired
    private UserRepository userRepository;
    //손승아, UserRepository 정상적으로 insert 되는지 테스트(정상동작확인), 20240316
    @Test
    public void testInsert(){
        
        for(int i = 1; i <= 10; i ++){
            User user = User.builder()
            .user_phone("휴대폰 번호 " + i)
            .user_pw("비밀번호 : "+i)
            .user_nick("이름 : "+i)
            .user_nation("국가명 : "+i)
            .user_birth("생년월일 : " +i)
            .user_gender("성별 :" +i)
            .join_dt(LocalDate.of(2024,03,16))
            .build();

            userRepository.save(user);
        }
    }

    //손승아, UserRepository 정상적으로 select 되는지 테스트(정상동작확인), 20240316 
    //2024-03-16T11:25:49.713+09:00  INFO 14988 --- [ttok] [           main] c.s.ttok.repository.UserRepositoryTests  : 
    //User(user_idx=3, user_phone=휴대폰 번호 3, user_pw=비밀번호 : 3, user_name=이름 : 3, user_nation=국가명 : 3, user_birth=생년월일 : 3, user_gender=성별 :3, user_start=창업여부 :3, join_dt=2024-03-16)
    @Test
    public void testRead(){
        Long user_idx= 3L;

        Optional<User> result = userRepository.findById(user_idx);

        User user = result.orElseThrow();
        
        log.info(user);
    }

    //손승아, 데이터 조회 후 필요한 내용 변경되는지 테스트(정상동작확인) ,20240317
    @Test
    public void testModify(){
        Long user_idx= 3L;
        Optional<User> result = userRepository.findById(user_idx);
        User user = result.orElseThrow();
        user.changeName("손승아");
        user.changePhone("01012341234");
        user.changePw("123456");
        userRepository.save(user);
    }

    //손승아, 데이터 삭제 테스트(정상동작확인), 20240317
    @Test
    public void testDelete(){
        Long user_idx = 1L;

        userRepository.deleteById(user_idx);
    }


}
