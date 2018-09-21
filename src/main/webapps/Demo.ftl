
public class ${tableName}{
    <#list fieldInfos as fieldInfo>
        private String ${fieldInfo.fieldName};
    </#list>
}