package designpattern.command;

/**
 * 大字体功能类
 * @author Frank Jiang
 * 
 */
public class BigFontCmd implements Command {

	private Font font;
	
	public BigFontCmd(Font font) {
		this.font = font;
	}
	
	@Override
	public void execute() {
		font.setFontSize("Big");
	}

}
