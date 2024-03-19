package com.smhrd.ttok.domain;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 손승아, tb_user 만드는 엔티티 생성, 20240316
@Entity
@Table(name="tb_user")
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_idx;
    private String user_phone;
    private String user_pw;
    private String user_nick;
    private String user_nation;
    private String user_birth;
    private String user_gender;
    private boolean user_start;
    private LocalDate join_dt;

    // 손승아 , 수정이 가능한 엔티티에 대해 변경 가능하게 하기, 20240317
    public void changePhone(String user_phone){
        this.user_phone = user_phone;
    }
    public void changePw(String user_pw){
        this.user_pw = user_pw;
    }
    public void changeName(String user_nick){
        this.user_nick = user_nick;
    } 
    public void changeStart(boolean user_start){
        this.user_start = user_start;
    }
    
    
}
