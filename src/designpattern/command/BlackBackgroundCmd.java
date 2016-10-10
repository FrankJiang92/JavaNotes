package designpattern.command;

/**
 * 黑色背景功能类
 * @author Frank Jiang
 *
 */
public class BlackBackgroundCmd implements Command {

	private Background background;
	
	public BlackBackgroundCmd(Background background) {
		this.background = background;
	}
	
	@Override
	public void execute() {
		background.setBackgroundColor("Black");
	}

}
