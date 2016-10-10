package designpattern.command;

/**
 * 白色背景功能类
 * @author Frank Jiang
 *
 */
public class WhiteBackgroundCmd implements Command {

	private Background background;
	
	public WhiteBackgroundCmd(Background background) {
		this.background = background;
	}
	
	@Override
	public void execute() {
		background.setBackgroundColor("White");
	}

}
