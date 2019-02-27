package com.hebaibai.entitymaker.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

/**
 * 用于生成java Entity文件的类
 */
@Getter
@Setter
@ToString
public class ClassModel {

    /**
     * java 中不需要引包的类型
     */
    private static List<String> baseClass = Arrays.asList(
            int.class.getName(),
            double.class.getName(),
            float.class.getName(),
            long.class.getName(),
            short.class.getName(),
            byte.class.getName(),
            char.class.getName(),
            boolean.class.getName(),
            String.class.getName()
    );

    /**
     * 类注释
     */

    private String classDoc;

    /**
     * 类名
     */
    private String className;

    /**
     * 类 包名
     */
    private String packageName;

    /**
     * K:属性名称
     * V:属性类型
     */
    private Map<String, Class> fields = new HashMap<>();

    /**
     * 属性的注释
     */
    private Map<String, String> fieldDoc = new HashMap<>();
    ;

    private List<String> imports = new ArrayList<>();

    /**
     * 添加需要导入的包
     *
     * @param className
     */
    public void addImport(String className) {
        if (baseClass.indexOf(className) != -1) {
            return;
        }
        if (imports.indexOf(className) == -1) {
            imports.add(className);
        }
    }

    /**
     * 添加属性
     *
     * @param fieldName  属性名称
     * @param fieldClass 属性类型
     */
    public void addfield(String fieldName, Class fieldClass) {
        if (!fields.containsKey(fieldName)) {
            fields.put(fieldName, fieldClass);
        }
    }

    /**
     * 添加属性注释
     *
     * @param fieldName 属性名称
     * @param fieldDoc  属性注释
     */
    public void addfieldDoc(String fieldName, String fieldDoc) {
        if (!this.fieldDoc.containsKey(fieldName)) {
            this.fieldDoc.put(fieldName, fieldDoc);
        }
    }


}
