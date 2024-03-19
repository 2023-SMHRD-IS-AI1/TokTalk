package com.smhrd.ttok.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.smhrd.ttok.DTO.UserDTO;
import com.smhrd.ttok.domain.User;
import com.smhrd.ttok.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor // 생성자 자동 주입
public class UserServiceImpl implements UserService {
    
    // 자동 주입 대상 -> final로 받기
    private final ModelMapper modelMapper;

    private final UserRepository userRepository;


    // 손승아, 등록 기능 구현, 20240319
    @Override
    public Long register(UserDTO userDTO) {
        log.info("로그로그");

        User user = modelMapper.map(userDTO, User.class);

        User savedUser = userRepository.save(user);
        
        return savedUser.getUser_idx();

    }
    // 손승아, 조회 기능 구현, 20240319
    @Override
    public UserDTO get(Long user_idx) {

        Optional<User> result = userRepository.findById(user_idx);
        User user = result.orElseThrow();
        UserDTO dto = modelMapper.map(user, UserDTO.class);
        return dto;
    }

    // 손승아, 수정 기능 구현, 20240319
    @Override
    public void modify(UserDTO userDTO) {
        // User 로딩 먼저
        Optional<User> result = userRepository.findById(userDTO.getUser_idx());
        User user = result.orElseThrow();

        // 변경된 내용을 반영
        user.changeName(userDTO.getUser_nick());
        user.changePhone(userDTO.getUser_phone());
        user.changePw(userDTO.getUser_pw());
        // 내용 저장
        userRepository.save(user);
    }
    // 손승아, 삭제 기능 구현,20240319
    @Override
    public void remove(Long user_idx) {
        userRepository.deleteById(user_idx);
    }
}
