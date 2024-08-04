package com.example.validator.groupednotnull;

public class ExampleGroupRules extends GroupRules{
    @Override
    protected void defineGroupRules() {
        registerGroupRules("two", 2, false);
        registerGroupRules("one", 1, true);
    }
}
