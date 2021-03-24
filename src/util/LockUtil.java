package util;

import java.util.HashMap;
import java.util.Map;

public class LockUtil {

	private static final Map<String, Object> lockMap = new HashMap<>();

	public static void wait(String name) {
		lockMap.put(name, new Object());
		try {
			Object lock = lockMap.get(name);
			synchronized (lock) {
				lock.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void notify(String name) {
		Object lock = lockMap.get(name);
		if (lock == null) {
			return;
		}
		synchronized (lock) {
			lock.notify();
		}
	}

}
