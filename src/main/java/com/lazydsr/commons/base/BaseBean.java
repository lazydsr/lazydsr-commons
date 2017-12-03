package com.lazydsr.commons.base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * BaseBeanImpl
 * PROJECT_NAME: lazy
 * PACKAGE_NAME: com.lazy.commons.base
 * Created by Lazy on 2017/9/17 0:35
 * Version: 1.1
 * Info: 基础工具类
 */
public class BaseBean<T> {
    public static final Integer LOG_LEVAEL_INFO = 0;
    public static final Integer LOG_LEVAEL_WARN = 1;
    public static final Integer LOG_LEVAEL_DEBUG = 2;
    public static final Integer LOG_LEVAEL_TRACE = 3;
    public static final Integer LOG_LEVAEL_ERROR = 4;
    public static final Integer LOG_LEVAEL_OTHER = 5;

    protected static Logger logger = null;


    public BaseBean() {
        Class<T> entityClass = null;
        try {
            Type genType = getClass().getGenericSuperclass();
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            entityClass = (Class) params[0];
            logger = LogManager.getLogger(entityClass);
        } catch (Exception e) {
            logger = LogManager.getLogger(BaseBean.class);
        }
    }

    public BaseBean(Class entityClass) {
        logger = LogManager.getLogger(entityClass);
    }


    /**
     * 打印日志工具类
     *
     * @param log 日志内容
     */
    public void writeLog(Object log) {
        error(log);
    }

    /**
     * 打印日志工具类
     *
     * @param log 日志内容
     */
    public void writeLog(Object log, Integer logLeavel) {
        if (logLeavel == LOG_LEVAEL_INFO) {
            info(log);
        } else if (logLeavel == LOG_LEVAEL_WARN) {
            warn(log);
        } else if (logLeavel == LOG_LEVAEL_DEBUG) {
            debug(log);
        } else if (logLeavel == LOG_LEVAEL_TRACE) {
            trace(log);
        } else if (logLeavel == LOG_LEVAEL_ERROR) {
            error(log);
        } else if (logLeavel == LOG_LEVAEL_OTHER) {
            info(log);
            debug(log);
            warn(log);
        } else {
            error(log);
        }
    }

    /**
     * Info日志
     *
     * @param log 日志内容
     */
    public void info(Object log) {
        logger.info(log.toString());
    }

    /**
     * Warn日志
     *
     * @param log 日志内容
     */
    public void warn(Object log) {
        logger.warn(log.toString());
    }

    /**
     * Debug日志
     *
     * @param log 日志内容
     */
    public void debug(Object log) {
        logger.debug(log.toString());
    }

    /**
     * Trace日志
     *
     * @param log 日志内容
     */
    public void trace(Object log) {
        logger.trace(log.toString());
    }

    /**
     * Error日志
     *
     * @param log 日志内容
     */
    public void error(Object log) {
        logger.error(log.toString());
    }


}

