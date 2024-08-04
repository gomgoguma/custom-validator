package com.example.validator.groupednotnull;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class GroupedNotNullConfig {

    @PostConstruct
    public void init() {
        new ExampleGroupRules().defineGroupRules(); // 그룹 설정 초기화
    }
}
