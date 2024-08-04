package com.example.validator.groupednotnull;

import java.util.HashMap;
import java.util.Map;

public abstract class GroupRules {
    private static final Map<String, GroupConfig> GROUP_RULES = new HashMap<>();

    protected void defineGroupRules() {
    }

    public static void registerGroupRules(String name, int requiredCount, boolean exactMatch) {
        GROUP_RULES.put(name, new GroupConfig(name, requiredCount, exactMatch));
    }

    public static GroupConfig getGroupConfig(String name) {
        return GROUP_RULES.get(name);
    }

    public record GroupConfig(String name, int requiredCount, boolean exactMatch) {}
}
