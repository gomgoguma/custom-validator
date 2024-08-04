package com.example.validator.groupednotnull;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class GroupedNotNullValidator implements ConstraintValidator<GroupedNotNullClass, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        Map<String, Integer> groupCounts = new HashMap<>();
        Field[] fields = value.getClass().getDeclaredFields();

        // 모든 필드 순회
        for (Field field : fields) {
            NotNullGroup annotation = field.getAnnotation(NotNullGroup.class);
            if (annotation != null) {
                field.setAccessible(true);
                try {
                    String groupName = annotation.name();

                    Object fieldValue = field.get(value);
                    groupCounts.put(groupName, groupCounts.getOrDefault(groupName, 0) + (fieldValue == null ? 0 : 1));

                } catch (IllegalAccessException e) {
                    log.warn("ConstraintValidator Failed", e);
                    return false;
                }
            }
        }

        // 그룹별 검증 로직
        for (String groupName : groupCounts.keySet()) {
            GroupRules.GroupConfig config = GroupRules.getGroupConfig(groupName);
            if (config != null) {
                int actualCount = groupCounts.get(groupName);
                if (config.exactMatch()) {
                    if (actualCount != config.requiredCount()) {
                        return false;
                    }
                } else {
                    if (actualCount < config.requiredCount()) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
