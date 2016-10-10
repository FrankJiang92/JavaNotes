package designpattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker调用类
 * @author Frank Jiang
 *
 */
public class Invoker {

	private List<Command> cmdList;
	
	public Invoker() {
		cmdList = new ArrayList<Command>();
	}
	
	public void setCommand(int i, Command command) {
		cmdList.add(i, command);
	}
	
	public void executeCmd(int i) {
		cmdList.get(i).execute();
	}
	
}
