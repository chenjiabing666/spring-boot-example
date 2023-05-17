package com.zengqingfa.springboot.state.demo.aop.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @fileName: LogCompare
 * @author: zengqf3
 * @date: 2021-4-6 13:37
 * @description:
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface LogResult {

    /**
     *执行的业务key
     *
     * @return String
     */
    String key();
}
