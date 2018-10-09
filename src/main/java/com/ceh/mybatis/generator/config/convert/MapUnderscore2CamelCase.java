package com.ceh.mybatis.generator.config.convert;

/**
 * Created by enHui.Chen on 2018/10/9.
 */
public class MapUnderscore2CamelCase implements NamingRuleConverter {
    @Override
    public String fieldConvert(String rawField) {
        if ("".equals(rawField) || rawField == null) return null;
        String[] rawArray = rawField.split("_");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < rawArray.length; i++) {
            if (i == 0) {
                sb.append(rawArray[i]);
                continue;
            }
            sb.append(rawArray[i].substring(0, 1).toUpperCase()).append(rawArray[i].substring(1));
        }
        return sb.toString();
    }
}
