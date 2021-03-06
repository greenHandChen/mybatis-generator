<#assign tableNameCapFirst = "${tableName?cap_first}">
<#if pkgName??>
package ${pkgName}.service;
</#if>

import ${pkgName}.dao.${tableNameCapFirst}Mapper;
import ${pkgName}.domain.${tableNameCapFirst};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Generated by ${generatedBy} on ${generatedTime?string["yyyy/MM/dd"]}.
 */
@Service
public class ${tableNameCapFirst}Service{

    @Autowired
    private ${tableNameCapFirst}Mapper ${tableName}Mapper;

    public List<${tableNameCapFirst}> queryAll(){
        return ${tableName}Mapper.queryAll();
    }
}