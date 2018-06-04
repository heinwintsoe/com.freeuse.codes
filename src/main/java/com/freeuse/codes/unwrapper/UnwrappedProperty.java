package com.freeuse.codes.unwrapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to define desired key name in the flattened map for a annotated property when it is
 * unwrapped into the flattened map.
 *
 * @author Hein
 * @since 1.0
 * 
 * <pre>
 * Revision History:
 * Version  Date            Author          Changes
 * ------------------------------------------------------------------------------------------------------------------------
 * 1.0      1 Jun 2018         Hein            Initial Coding
 *
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UnwrappedProperty {
	public String value() default "";
}
