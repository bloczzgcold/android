package com.github.hualuomoli.logger;

import android.util.Log;

import com.github.hualuomoli.logger.helpers.FormattingTuple;
import com.github.hualuomoli.logger.helpers.MessageFormatter;

/**
 * 日志
 */
public class Logger {

    /**
     * 应用级别，默认关闭
     */
    private static Level level = Level.OFF;

    public static void setLevel(Level level) {
        Logger.level = level;
    }

    /**
     * 是否可以verbose级别输出
     *
     * @return 如果应用设置的级别小于或等于verbose返回true，否则返回false
     */
    public static boolean isVerboseEnabled() {
        return Level.VERBOSE.isGreaterOrEqual(level);
    }


    /**
     * verbose级别输出日志
     *
     * @param tag 标签
     * @param msg 信息
     */
    public static void verbose(String tag, String msg) {
        if (!isVerboseEnabled()) {
            return;
        }
        showVerbose(tag, msg, null);
    }


    /**
     * verbose级别输出日志
     *
     * @param tag    标签
     * @param format 信息格式
     * @param arg    参数
     */
    public static void verbose(String tag, String format, Object arg) {
        if (!isVerboseEnabled()) {
            return;
        }
        FormattingTuple tp = MessageFormatter.format(format, arg);
        showVerbose(tag, tp.getMessage(), tp.getThrowable());
    }


    /**
     * verbose级别输出日志
     *
     * @param tag    标签
     * @param format 信息格式
     * @param arg1   参数1
     * @param arg2   参数2
     */
    public static void verbose(String tag, String format, Object arg1, Object arg2) {
        if (!isVerboseEnabled()) {
            return;
        }
        FormattingTuple tp = MessageFormatter.format(format, arg1, arg2);
        showVerbose(tag, tp.getMessage(), tp.getThrowable());
    }

    /**
     * verbose级别输出日志
     *
     * @param tag       标签
     * @param format    信息格式
     * @param arguments 参数
     */
    public static void verbose(String tag, String format, Object... arguments) {
        if (!isVerboseEnabled()) {
            return;
        }
        FormattingTuple tp = MessageFormatter.arrayFormat(format, arguments);
        showVerbose(tag, tp.getMessage(), tp.getThrowable());
    }

    /**
     * verbose级别输出日志
     *
     * @param tag 标签
     * @param msg 信息
     * @param t   异常
     */
    public static void verbose(String tag, String msg, Throwable t) {
        if (!isVerboseEnabled()) {
            return;
        }
        showVerbose(tag, msg, t);
    }

    /**
     * 输出verbose级别的日志
     *
     * @param tag 标签
     * @param msg 信息
     * @param t   异常
     */
    private static void showVerbose(String tag, String msg, Throwable t) {
        if (msg == null) {
            msg = "";
        }
        if (t == null) {
            Log.v(tag, msg);
        } else {
            Log.v(tag, msg, t);
        }
    }

    /**
     * 是否可以debug级别输出
     *
     * @return 如果应用设置的级别小于或等于debug返回true，否则返回false
     */
    public static boolean isDebugEnabled() {
        return Level.DEBUG.isGreaterOrEqual(level);
    }


    /**
     * debug级别输出日志
     *
     * @param tag 标签
     * @param msg 信息
     */
    public static void debug(String tag, String msg) {
        if (!isDebugEnabled()) {
            return;
        }
        showDebug(tag, msg, null);
    }


    /**
     * debug级别输出日志
     *
     * @param tag    标签
     * @param format 信息格式
     * @param arg    参数
     */
    public static void debug(String tag, String format, Object arg) {
        if (!isDebugEnabled()) {
            return;
        }
        FormattingTuple tp = MessageFormatter.format(format, arg);
        showDebug(tag, tp.getMessage(), tp.getThrowable());
    }


    /**
     * debug级别输出日志
     *
     * @param tag    标签
     * @param format 信息格式
     * @param arg1   参数1
     * @param arg2   参数2
     */
    public static void debug(String tag, String format, Object arg1, Object arg2) {
        if (!isDebugEnabled()) {
            return;
        }
        FormattingTuple tp = MessageFormatter.format(format, arg1, arg2);
        showDebug(tag, tp.getMessage(), tp.getThrowable());
    }

    /**
     * debug级别输出日志
     *
     * @param tag       标签
     * @param format    信息格式
     * @param arguments 参数
     */
    public static void debug(String tag, String format, Object... arguments) {
        if (!isDebugEnabled()) {
            return;
        }
        FormattingTuple tp = MessageFormatter.arrayFormat(format, arguments);
        showDebug(tag, tp.getMessage(), tp.getThrowable());
    }

    /**
     * debug级别输出日志
     *
     * @param tag 标签
     * @param msg 信息
     * @param t   异常
     */
    public static void debug(String tag, String msg, Throwable t) {
        if (!isDebugEnabled()) {
            return;
        }
        showDebug(tag, msg, t);
    }

    /**
     * 输出debug级别的日志
     *
     * @param tag 标签
     * @param msg 信息
     * @param t   异常
     */
    private static void showDebug(String tag, String msg, Throwable t) {
        if (msg == null) {
            msg = "";
        }
        if (t == null) {
            Log.d(tag, msg);
        } else {
            Log.d(tag, msg, t);
        }
    }

    /**
     * 是否可以info级别输出
     *
     * @return 如果应用设置的级别小于或等于info返回true，否则返回false
     */
    public static boolean isInfoEnabled() {
        return Level.INFO.isGreaterOrEqual(level);
    }


    /**
     * info级别输出日志
     *
     * @param tag 标签
     * @param msg 信息
     */
    public static void info(String tag, String msg) {
        if (!isInfoEnabled()) {
            return;
        }
        showInfo(tag, msg, null);
    }


    /**
     * info级别输出日志
     *
     * @param tag    标签
     * @param format 信息格式
     * @param arg    参数
     */
    public static void info(String tag, String format, Object arg) {
        if (!isInfoEnabled()) {
            return;
        }
        FormattingTuple tp = MessageFormatter.format(format, arg);
        showInfo(tag, tp.getMessage(), tp.getThrowable());
    }


    /**
     * info级别输出日志
     *
     * @param tag    标签
     * @param format 信息格式
     * @param arg1   参数1
     * @param arg2   参数2
     */
    public static void info(String tag, String format, Object arg1, Object arg2) {
        if (!isInfoEnabled()) {
            return;
        }
        FormattingTuple tp = MessageFormatter.format(format, arg1, arg2);
        showInfo(tag, tp.getMessage(), tp.getThrowable());
    }

    /**
     * info级别输出日志
     *
     * @param tag       标签
     * @param format    信息格式
     * @param arguments 参数
     */
    public static void info(String tag, String format, Object... arguments) {
        if (!isInfoEnabled()) {
            return;
        }
        FormattingTuple tp = MessageFormatter.arrayFormat(format, arguments);
        showInfo(tag, tp.getMessage(), tp.getThrowable());
    }

    /**
     * info级别输出日志
     *
     * @param tag 标签
     * @param msg 信息
     * @param t   异常
     */
    public static void info(String tag, String msg, Throwable t) {
        if (!isInfoEnabled()) {
            return;
        }
        showInfo(tag, msg, t);
    }

    /**
     * 输出info级别的日志
     *
     * @param tag 标签
     * @param msg 信息
     * @param t   异常
     */
    private static void showInfo(String tag, String msg, Throwable t) {
        if (msg == null) {
            msg = "";
        }
        if (t == null) {
            Log.i(tag, msg);
        } else {
            Log.i(tag, msg, t);
        }
    }

    /**
     * 是否可以warn级别输出
     *
     * @return 如果应用设置的级别小于或等于warn返回true，否则返回false
     */
    public static boolean isWarnEnabled() {
        return Level.WARN.isGreaterOrEqual(level);
    }


    /**
     * warn级别输出日志
     *
     * @param tag 标签
     * @param msg 信息
     */
    public static void warn(String tag, String msg) {
        if (!isWarnEnabled()) {
            return;
        }
        showWarn(tag, msg, null);
    }


    /**
     * warn级别输出日志
     *
     * @param tag    标签
     * @param format 信息格式
     * @param arg    参数
     */
    public static void warn(String tag, String format, Object arg) {
        if (!isWarnEnabled()) {
            return;
        }
        FormattingTuple tp = MessageFormatter.format(format, arg);
        showWarn(tag, tp.getMessage(), tp.getThrowable());
    }


    /**
     * warn级别输出日志
     *
     * @param tag    标签
     * @param format 信息格式
     * @param arg1   参数1
     * @param arg2   参数2
     */
    public static void warn(String tag, String format, Object arg1, Object arg2) {
        if (!isWarnEnabled()) {
            return;
        }
        FormattingTuple tp = MessageFormatter.format(format, arg1, arg2);
        showWarn(tag, tp.getMessage(), tp.getThrowable());
    }

    /**
     * warn级别输出日志
     *
     * @param tag       标签
     * @param format    信息格式
     * @param arguments 参数
     */
    public static void warn(String tag, String format, Object... arguments) {
        if (!isWarnEnabled()) {
            return;
        }
        FormattingTuple tp = MessageFormatter.arrayFormat(format, arguments);
        showWarn(tag, tp.getMessage(), tp.getThrowable());
    }

    /**
     * warn级别输出日志
     *
     * @param tag 标签
     * @param msg 信息
     * @param t   异常
     */
    public static void warn(String tag, String msg, Throwable t) {
        if (!isWarnEnabled()) {
            return;
        }
        showWarn(tag, msg, t);
    }

    /**
     * 输出warn级别的日志
     *
     * @param tag 标签
     * @param msg 信息
     * @param t   异常
     */
    private static void showWarn(String tag, String msg, Throwable t) {
        if (msg == null) {
            msg = "";
        }
        if (t == null) {
            Log.w(tag, msg);
        } else {
            Log.w(tag, msg, t);
        }
    }

    /**
     * 是否可以error级别输出
     *
     * @return 如果应用设置的级别小于或等于error返回true，否则返回false
     */
    public static boolean isErrorEnabled() {
        return Level.ERROR.isGreaterOrEqual(level);
    }


    /**
     * error级别输出日志
     *
     * @param tag 标签
     * @param msg 信息
     */
    public static void error(String tag, String msg) {
        if (!isErrorEnabled()) {
            return;
        }
        showError(tag, msg, null);
    }


    /**
     * error级别输出日志
     *
     * @param tag    标签
     * @param format 信息格式
     * @param arg    参数
     */
    public static void error(String tag, String format, Object arg) {
        if (!isErrorEnabled()) {
            return;
        }
        FormattingTuple tp = MessageFormatter.format(format, arg);
        showError(tag, tp.getMessage(), tp.getThrowable());
    }


    /**
     * error级别输出日志
     *
     * @param tag    标签
     * @param format 信息格式
     * @param arg1   参数1
     * @param arg2   参数2
     */
    public static void error(String tag, String format, Object arg1, Object arg2) {
        if (!isErrorEnabled()) {
            return;
        }
        FormattingTuple tp = MessageFormatter.format(format, arg1, arg2);
        showError(tag, tp.getMessage(), tp.getThrowable());
    }

    /**
     * error级别输出日志
     *
     * @param tag       标签
     * @param format    信息格式
     * @param arguments 参数
     */
    public static void error(String tag, String format, Object... arguments) {
        if (!isErrorEnabled()) {
            return;
        }
        FormattingTuple tp = MessageFormatter.arrayFormat(format, arguments);
        showError(tag, tp.getMessage(), tp.getThrowable());
    }

    /**
     * error级别输出日志
     *
     * @param tag 标签
     * @param msg 信息
     * @param t   异常
     */
    public static void error(String tag, String msg, Throwable t) {
        if (!isErrorEnabled()) {
            return;
        }
        showError(tag, msg, t);
    }

    /**
     * 输出error级别的日志
     *
     * @param tag 标签
     * @param msg 信息
     * @param t   异常
     */
    private static void showError(String tag, String msg, Throwable t) {
        if (msg == null) {
            msg = "";
        }
        if (t == null) {
            Log.e(tag, msg);
        } else {
            Log.e(tag, msg, t);
        }
    }

}
