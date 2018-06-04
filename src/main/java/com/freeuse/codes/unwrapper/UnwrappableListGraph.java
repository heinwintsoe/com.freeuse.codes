package com.freeuse.codes.unwrapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marker annotation to mark a list property in an object graph so that it can be 
 * detected by {@link ObjGraphUnwrapper}.
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
public @interface UnwrappableListGraph {
}
