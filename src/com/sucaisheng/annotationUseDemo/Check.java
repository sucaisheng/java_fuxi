package com.sucaisheng.annotationUseDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.*;

/**
 * 自定义测试注解
 *   用于检测一段代码中方法是否有异常
 */
@Target({ElementType.METHOD})
@Retention(RUNTIME)
public @interface Check {
}
