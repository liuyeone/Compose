package com.example.mysql.config;

public class DataSourceContextHolder {
    // 默认数据源
    public static final String DEFAULT_DS = "user";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDB(String dbType) {
        contextHolder.set(dbType);
    }

    public static String getDB() {
        return (contextHolder.get());
    }

    public static void clearDB() {
        contextHolder.remove();
    }
}
