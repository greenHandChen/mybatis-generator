<#if pkgName??>
package ${pkgName};
</#if>

<#list fieldInfos as fieldInfo>
import ${fieldInfo.dbFieldType.pkg};
</#list>

@Data
public class ${tableName?cap_first}{

<#list fieldInfos as fieldInfo>
        private ${fieldInfo.dbFieldType.type} ${fieldInfo.fieldName};

</#list>

}