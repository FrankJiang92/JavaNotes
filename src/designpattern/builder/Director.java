package designpattern.builder;

public class Director {

	private WasherBuilder builder;
	
	public Director(WasherBuilder builder) {
		this.builder = builder;
	} 
	
	public void construct() {
		builder.buildSkeleton();
		builder.buildEngine();
		builder.buildWheels();
		builder.buildBody();
	}
}
