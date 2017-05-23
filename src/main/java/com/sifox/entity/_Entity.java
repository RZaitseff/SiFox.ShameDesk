package com.sifox.entity;
/**
 * 
 * @Author Zaytsev Roman V.
 * @date 18.05.2017
 */

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.persistence.Table;

public abstract class _Entity {
	public abstract int getId();
	public String getTableName() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		final Annotation a = getClass().getAnnotation(Table.class);
		final Class<?> type = a.annotationType();
		final Method m = type.getMethod("name");
		final String name = (String) m.invoke(a);
		return name;
	}
}
