package com.my.membership.config;

import com.my.membership.repository.MemberRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberRepositoryImpl memberRepository() {
        return new MemberRepositoryImpl();
    }
}
