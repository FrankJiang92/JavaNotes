package designpattern.builder;

public class MediaWasherBuilder implements WasherBuilder {

	private MediaWasher mediaWasher = new MediaWasher();
	
	@Override
	public void buildSkeleton() {
		mediaWasher.setSkeleton("[ media skeleton ]");
	}

	@Override
	public void buildEngine() {
		mediaWasher.setEngine("[ media engine ]");
	}

	@Override
	public void buildWheels() {
		mediaWasher.setWheels("[ media wheels ]");
	}

	@Override
	public void buildBody() {
		mediaWasher.setBody("[ media body ]");
	}

	public MediaWasher getWasher() {
		return mediaWasher;
	}
}
