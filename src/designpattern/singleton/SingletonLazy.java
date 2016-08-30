package designpattern.singleton;

/**
 * 单例模式-懒汉式
 * @author FrankJiang
 */
public class SingletonLazy {
	
	/*
	 * 延迟创建 
	 */
	private static SingletonLazy instance;
	
	private SingletonLazy() {
	}
	
	public static SingletonLazy getInstance() {
		if (instance == null) {
			synchronized(SingletonLazy.class) {
				if (instance == null)
					instance = new SingletonLazy();
			}
		}
		
		return instance;
	}
}
