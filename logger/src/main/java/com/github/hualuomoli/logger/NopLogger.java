package com.github.hualuomoli.logger;

/**
 * Created by admin on 2018/2/10.
 */

public class NopLogger implements ILogger {

    @Override
    public void verbose(String tag, String msg) {
    }

    @Override
    public void verbose(String tag, String msg, Throwable t) {
    }

    @Override
    public void debug(String tag, String msg) {
    }

    @Override
    public void debug(String tag, String msg, Throwable t) {
    }

    @Override
    public void info(String tag, String msg) {
    }

    @Override
    public void info(String tag, String msg, Throwable t) {
    }

    @Override
    public void warn(String tag, String msg) {
    }

    @Override
    public void warn(String tag, String msg, Throwable t) {
    }

    @Override
    public void error(String tag, String msg) {
    }

    @Override
    public void error(String tag, String msg, Throwable t) {
    }

}
