package designpattern.command;

/**
 * 正常字体功能类
 * @author Frank Jiang
 *
 */
public class NormalFontCmd implements Command {

	private Font font;
	
	public NormalFontCmd(Font font) {
		this.font = font;
	}
	
	@Override
	public void execute() {
		font.setFontSize("Normal");
	}

}
