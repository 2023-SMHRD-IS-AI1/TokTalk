package com.smhrd.ttok.service;

import com.smhrd.ttok.DTO.UserDTO;

public interface UserService {
    
    //손승아, 등록 기능 선언, 20240317
    Long register(UserDTO userDTO);
    //손승아, 조회 기능 선언, 20240319
    UserDTO get(Long user_idx);
    //손승아, 수정 기능 선언, 20240319
    void modify(UserDTO userDTO);
    //손승아, 삭제 기능 선언, 20240319
    void remove(Long user_idx);
}
