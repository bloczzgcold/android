package com.github.hualuomoli.logger;

/**
 * 日志级别
 */
public class Level {

    private static final int OFF_INT = Integer.MAX_VALUE;
    private static final int ERROR_INT = 40000;
    private static final int WARN_INT = 30000;
    private static final int INFO_INT = 20000;
    private static final int DEBUG_INT = 10000;
    private static final int VERBOSE_INT = 0000;
    private static final int ALL_INT = Integer.MIN_VALUE;

    /**
     * 关闭
     */
    public static final Level OFF = new Level(OFF_INT, "OFF");

    /**
     * 错误
     */
    public static final Level ERROR = new Level(ERROR_INT, "ERROR");

    /**
     * 警告
     */
    public static final Level WARN = new Level(WARN_INT, "WARN");

    /**
     * 信息
     */
    public static final Level INFO = new Level(INFO_INT, "INFO");

    /**
     * 调试
     */
    public static final Level DEBUG = new Level(DEBUG_INT, "DEBUG");

    /**
     * 随意
     */
    public static final Level VERBOSE = new Level(VERBOSE_INT, "TRACE");

    /**
     * 全部
     */
    public static final Level ALL = new Level(ALL_INT, "ALL");

    private int level;
    private String levelStr;

    public Level(int level, String levelStr) {
        this.level = level;
        this.levelStr = levelStr;
    }

    /**
     * 当前级别是否大于等于比较的级别
     *
     * @param l 待比较的级别
     * @return 当前级别是否大于等于比较的级别
     */
    public boolean isGreaterOrEqual(Level l) {
        return level >= l.level;
    }

    @Override
    public String toString() {
        return "Level{" +
                "level=" + level +
                ", levelStr='" + levelStr + '\'' +
                '}';
    }
}
