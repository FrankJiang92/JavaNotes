package designpattern.builder;

/**
 * 冰箱 Builder 接口
 * @author jiangfan_sx
 *
 */
public interface WasherBuilder {
	
	/**
	 * 框架
	 */
	public void buildSkeleton();
	
	/**
	 * 引擎
	 */
	public void buildEngine();
	
	/**
	 * 轮子
	 */
	public void buildWheels();
	
	/**
	 * 箱体
	 */
	public void buildBody();
}
