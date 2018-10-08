<#if pkgName??>
package ${pkgName};
</#if>

<#list fieldsInfos as fieldInfo>
import ${fieldInfo.dbFieldType.pkg}
</#list>

public class ${tableName}{

<#list fieldInfos as fieldInfo>
        private ${fieldInfo.type} ${fieldInfo.fieldName};
</#list>

}