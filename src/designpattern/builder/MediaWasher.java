package designpattern.builder;

public class MediaWasher {

	private String skeleton;
	private String engine;
	private String wheels;
	private String body;
	
	public String getSkeleton() {
		return skeleton;
	}
	public void setSkeleton(String skeleton) {
		this.skeleton = skeleton;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getWheels() {
		return wheels;
	}
	public void setWheels(String wheels) {
		this.wheels = wheels;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		return "MediaWasher [skeleton=" + skeleton + ", engine=" + engine + ", wheels=" + wheels + ", body=" + body
				+ "]";
	}
	
	
}
