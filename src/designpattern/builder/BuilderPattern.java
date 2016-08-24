package designpattern.builder;

public class BuilderPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. media washer的建造器
		MediaWasherBuilder mediaWasherBuilder = new MediaWasherBuilder();
		
		// 2. director
		Director director = new Director(mediaWasherBuilder);
		
		// 3. 生产
		director.construct();
		
		// 4. 获得产品
		MediaWasher washer = mediaWasherBuilder.getWasher();
		
		System.out.println("---->" + washer);
	}

}
