package com.ncwitmobileapp.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation on method specifying that the method is a service method
 * and needs to have the corresponding request factory code 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface ServiceMethod {

}
