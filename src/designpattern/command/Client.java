package designpattern.command;

public class Client {

	public static final int ID_NORMAL_FONT = 0;
	public static final int ID_BIG_FONT = 1;
	public static final int ID_WHITE_BACKGROUND = 2;
	public static final int ID_BLACK_BACKGROUND = 2;
	
	public static void main(String[] args) {
		Font font = new Font();
		Background background = new Background();
		
		Command normalFontCmd = new NormalFontCmd(font);
		Command bigFontCmd = new BigFontCmd(font);
		
		Command whiteBackgroundCmd = new WhiteBackgroundCmd(background);
		Command blackBackgroundCmd = new BlackBackgroundCmd(background);
		
		Invoker invoker = new Invoker();
		invoker.setCommand(ID_NORMAL_FONT, normalFontCmd);
		invoker.setCommand(ID_BIG_FONT, bigFontCmd);
		invoker.setCommand(ID_WHITE_BACKGROUND, whiteBackgroundCmd);
		invoker.setCommand(ID_BLACK_BACKGROUND, blackBackgroundCmd);
		
		System.out.println("============== Before ===============");
		System.out.println("FontSize:" + font.getFontSize());
		System.out.println("BackgroundColor:" + background.getBackgroundColor());
		System.out.println("============== After  ===============");
		invoker.executeCmd(ID_BIG_FONT);
		invoker.executeCmd(ID_BLACK_BACKGROUND);
	}

}
