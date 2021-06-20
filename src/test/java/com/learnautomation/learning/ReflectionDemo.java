package com.learnautomation.learning;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		MyTest obj=new MyTest();
		
		Class cls=obj.getClass();
		
		System.out.println(cls.getName());
		
		Constructor cons=cls.getConstructor();
		
		System.out.println(cons.getName());
		
		Method[] mt=cls.getMethods();

		for(Method m:mt)
		{
			//System.out.println(m.getName());
		}
		
		Method m1=cls.getDeclaredMethod("method2", int.class);
		
		m1.invoke(obj, 500);
		
		Field field=cls.getDeclaredField("name");
		
		field.set(obj, "Jenkins");
		
		Method m2=cls.getDeclaredMethod("method1");
		
		m2.invoke(obj);
		
		Method m3=cls.getDeclaredMethod("method3");
		
		m3.setAccessible(true);
		
		m3.invoke(obj);
		
	}

}
