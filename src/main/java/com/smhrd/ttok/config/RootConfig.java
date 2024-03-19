package com.smhrd.ttok.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 손승아, ModelMapper를 사용하기 위한 설정, 20240317
@Configuration
public class RootConfig {
    
    @Bean
    public ModelMapper getMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                   .setFieldMatchingEnabled(true) // modelmapper가 객체 필드를 매핑할 때 필드 이름을 기준으로 매핑
                   .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE) //private 필드에 접근가능 설정
                   .setMatchingStrategy(MatchingStrategies.LOOSE); // 매핑 전략 설정. 정해지지 않은 필드의 이름 매핑도 시도
        return modelMapper;
    }
}
