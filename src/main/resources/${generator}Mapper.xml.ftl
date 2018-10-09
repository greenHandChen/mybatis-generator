<#assign tableNameCapFirst = "${tableName?cap_first}">
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace：命名空间，用于隔离sql -->
<mapper namespace="${pkgName}.dao.${tableNameCapFirst}Mapper">
    <select id="queryAll" resultType="${pkgName}.domain.${tableNameCapFirst}">
        select t.* from ${tableNameCapFirst} t
    </select>
</mapper>
