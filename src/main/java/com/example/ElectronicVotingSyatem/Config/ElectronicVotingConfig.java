package com.example.ElectronicVotingSyatem.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElectronicVotingConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
