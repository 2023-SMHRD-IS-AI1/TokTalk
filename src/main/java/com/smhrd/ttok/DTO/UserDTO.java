package com.smhrd.ttok.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 손승아 , 엔티티 객체 처리를 위한 DTO 생성, 20240317
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long user_idx;

    private String user_nick;
    private String user_phone;
    private String user_pw;
    private String user_nation;
    private String user_birth;
    private String user_gender;
    private boolean user_start;

    // 날짜를 화면 상에서 쉽게 처리하기 위해 포맷을 구성함
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate join_dt;

    
}
