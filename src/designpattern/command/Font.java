package designpattern.command;

/**
 * 字体功能类
 * @author Frank Jiang
 */
public class Font {

	private String fontSize = "Normal";
	
	public String getFontSize() {
		return fontSize;
	}
	
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
		System.out.println("FontSize:" + fontSize);
	}

}
