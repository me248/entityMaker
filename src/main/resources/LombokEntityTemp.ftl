package ${packageName};

<#--导入的包-->
<#list imports as import>
import ${import};
</#list>

<#--类名-->
<#if classDoc?length gt 0>
/**
 * ${classDoc}
 * @author hejiaxuan
 */
</#if>
@Getter
@Setter
@ToString
@Table("${tableName}")
public class ${className} {

<#--属性名称-->
<#list fields?keys as key>
    <#assign  fieldDocStr = fieldDoc[key]>
    <#if fieldDocStr?length gt 0>
    /**${fieldDocStr}*/
    </#if>
    <#if idColumnNames?seq_contains(fieldSqlName[key])>
    @Id
    </#if>
    @Column("${fieldSqlName[key]}")
    private ${fields[key].simpleName} ${key};

</#list>

}