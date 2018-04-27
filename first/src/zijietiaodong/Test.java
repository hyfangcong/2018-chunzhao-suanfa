package zijietiaodong;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	
	private String name;
	public String age;
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, InstantiationException{
		Test test = new Test();
		Class<?> clazz = Class.forName("zijietiaodong.Test");
		Class<?> class1 = test.getClass();
		Method method = test.getClass().getMethod("f1",String.class);
		method.invoke(test,"fangcong");
		System.out.println(test.getClass().getMethod("f1",String.class));
		Field field = test.getClass().getDeclaredField("name");
		System.out.println(Test.class);
		Constructor<?>[] cons = class1.getConstructors();
		//field.setAccessible(true);
		Object object = class1.newInstance();
		field.set(object,"fangcong");
		System.out.println(field.get(object));
	}	
	
	public Object f1(String name){
		System.out.println(name+"fanshe");
		return new Test();
	}
}
