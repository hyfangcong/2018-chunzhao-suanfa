package zijietiaodong;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test006 {
	
	public static void main(String[] arg) throws Exception{
		
		Test obj = new Test();
		Object[] args = new Object[]{"fangcong"};
 			Test object =(Test) invokeMethod(obj,"f1", args);
 			String ss = object.f1("facong").toString();
 			System.err.println(ss);
		
	}
	
	
	public static Object invokeMethod(Object obj,String methodName,Object[] args)throws Exception{
		Class<?>[] argClass = new Class<?>[args.length];
		for(int i=0;i<args.length;i++){
			argClass[i] = args[i].getClass();
		}
		
		Class<?> clazz = obj.getClass();
		Method method = clazz.getMethod(methodName, argClass);
		return method.invoke(obj, args);
	}
}
