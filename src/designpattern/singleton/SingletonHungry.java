package designpattern.singleton;

/**
 * 单例模式-饿汉式
 * @author FrankJiang
 */
public class SingletonHungry {

	/*
	 * 类加载时创建
	 */
	private final static SingletonHungry instance 
							= new SingletonHungry();
	
	private SingletonHungry() {
	}
	
	public static SingletonHungry getInstance() {
		return instance;
	}
}
