package com.ceh.mybatis.generator.config.rules;

/**
 * Created by enHui.Chen on 2018/10/9.
 */
public enum NamingRuleType {

    CamelCase("CamelCase"),

    MapUnderScore("MapUnderScore");

    private String ruleType;

    NamingRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public static NamingRuleType parseNamingRuleType(String ruleType) {
        for (NamingRuleType namingRuleType : NamingRuleType.values()) {
            if (namingRuleType.getRuleType().toLowerCase().trim().equals(ruleType.toLowerCase().trim())) {
                return namingRuleType;
            }
        }
        return null;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }
}
