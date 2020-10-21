package com.java.study.jdbc;

/**
 * @author : RXK
 * Date : 2020/4/7 15:01
 * Desc:
 */
public enum EDataSource {
    MYSQL(1, "mysql","mysql数据库",MysqlDataSource.class),
    MONGODB(2, "mongodb","mongodb数据库", MongodbDataSource.class),
    HIVE(3, "hive","hive数据库", HiveDataSource.class),
    REDIS(4, "redis","redis数据库", MysqlDataSource.class)
    ;
    private final Integer type;
    private final String code;
    private final String description;
    private final Class aClass;

    EDataSource(Integer type, String code, String description, Class aClass) {
        this.type = type;
        this.code = code;
        this.description = description;
        this.aClass = aClass;
    }


    public static EDataSource eDataSourceByCode(String code) {
        for (EDataSource eDataSource : EDataSource.values()) {
            if (eDataSource.code.equals(code)) {
                return eDataSource;
            }
        }
        return null;
    }
    public static EDataSource eDataSourceByType(Integer type) {
        for (EDataSource eDataSource : EDataSource.values()) {
            if (eDataSource.type.intValue()==type.intValue()) {
                return eDataSource;
            }
        }
        return null;
    }


    public Integer getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Class getaClass() {
        return aClass;
    }
}
