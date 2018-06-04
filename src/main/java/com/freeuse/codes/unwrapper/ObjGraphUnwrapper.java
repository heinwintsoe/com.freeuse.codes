package com.freeuse.codes.unwrapper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.reflect.FieldUtils;

/**
 * Utility class to unwrap object graph to flat map. Need to use with
 * {@link UnwrappedProperty}, {@link UnwrappableListGraph} and {@link UnwrappableObjGraph} annotations.
 * As collection nested object, only List property is supported.
 * 
 * @author Hein
 * @since 1.0
 * 
 *        <pre>
 * Revision History:
 * Version  Date            Author          Changes
 * ------------------------------------------------------------------------------------------------------------------------
 * 1.0      1 Jun 2018         Hein            Initial Coding
 *
 *        </pre>
 */
public class ObjGraphUnwrapper {
	
	private boolean ignoreNullValue = false;

	private Map<String, Object> flatValues = new HashMap<>();
	
	private String currentProfile;
	
	private Object objToUnwrap;
	
	public static ObjGraphUnwrapper of(Object objToUnwrap) {
		ObjGraphUnwrapper wrapper = new ObjGraphUnwrapper();
		wrapper.objToUnwrap = objToUnwrap;
		return wrapper;
	}
	
	public Map<String, Object> unwrap() throws UnwrappingFailedException {
		return unwrappAsFlatMap(objToUnwrap);
	}

	public Map<String, Object> unwrappAsFlatMap(Object objToUnwrap)
			throws UnwrappingFailedException {
		try {
			Field[] fields = FieldUtils.getAllFields(objToUnwrap.getClass());
			for (Field field : fields) {
				Object fieldValue = FieldUtils.readField(field, objToUnwrap, true);
				// If the field value is unwrappable object
				if (field.isAnnotationPresent(UnwrappableObjGraph.class)) {
					unwrappAsFlatMap(fieldValue);
				// If the field value is unwrappable list
				} else if (field.isAnnotationPresent(UnwrappableListGraph.class)) {
					unwrappListGraph(fieldValue);
				// If it is unwrappable direct property
				} else if (field.isAnnotationPresent(UnwrappedProperty.class)) {
					if(fieldValue != null || !ignoreNullValue) {
						UnwrappedProperty jsonProperty = field.getAnnotation(UnwrappedProperty.class);
						UnwrappedProfile[] profiles = jsonProperty.profiles();
						if(profiles.length == 0) {
							flatValues.put(jsonProperty.value(), fieldValue);
						} else {
							for(UnwrappedProfile profile : profiles) {
								if(profile.profile().equals(currentProfile)) {
									flatValues.put(profile.value(), fieldValue);
								}
							}
						}
					}
				}
			}
		} catch (SecurityException | IllegalAccessException e) {
			throw new UnwrappingFailedException(e);
		}
		return flatValues;
	}

	private void unwrappListGraph(Object fieldValue) throws UnwrappingFailedException {
		List<?> listItems = (List<?>) fieldValue;
		if (listItems != null && !listItems.isEmpty()) {
			for (Object item : listItems) {
				unwrappAsFlatMap(item);
			}
		}
	}

	public Map<String, Object> getFlatMap() {
		return flatValues;
	}

	public ObjGraphUnwrapper setFlatMap(Map<String, Object> flatValues) {
		this.flatValues = flatValues;
		return this;
	}

	public ObjGraphUnwrapper ignoreNullValue(boolean ignore) {
		this.ignoreNullValue = ignore;
		return this;
	}
	
	public ObjGraphUnwrapper setProfile(String profile) {
		this.currentProfile = profile;
		return this;
	}
	
	public String getProfile(String profile) {
		return this.currentProfile;
	}

}
