package examples.designPattern;

import java.lang.reflect.Method;

public class MethodProxy {
	Object obj;
	public MethodProxy(Object obj) {
		this.obj = obj;
	}
	
	public Object invoke(String methodName, Object... params) {
		try {
			Class<?>[] typeArray = new Class<?>[params.length];
			for (int i = 0; i < typeArray.length; i++) {
				typeArray[i] = params[i].getClass();
			}
			Method method = obj.getClass().getDeclaredMethod(methodName, typeArray);
			return method.invoke(obj, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
