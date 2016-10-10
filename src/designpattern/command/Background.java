package designpattern.command;

/**
 * 背景功能类
 * @author Frank Jiang
 */
public class Background {

	private String backgroundColor = "White";

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
		System.out.println("BackgroundColor:" + backgroundColor);
	}
	
}
