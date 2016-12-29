package notegen.main;

import java.util.Calendar;
import java.util.Date;

import notegen.logger.Log;
import notegen.util.DateUtil;
import notegen.util.FileUtil;

public class Notegen {

	public static String TYPE = ".md";
	public static String TITLE = "### %s";
	public static String README = "* [列表目录](../README.md)";
	public static String BEFORE = "* [ 前一天 ](../%s/%s.md)";
	public static String AFTER = "* [ 后一天 ](../%s/%s.md)";
	public static String TASK = "> 工作任务";
	
	public static void main(String[] args) {
		Notegen gen = new Notegen();
		gen.generateNote();
	}
	
	
	public void generateNote() {
		String path = "e:/Notegen/";
		Date date = new Date();
		try {
			generate(date, 10, path);
		} catch (Exception e) {
			Log.error("generateNote error:", e);
		}
	}
	
	public void generate(Date start, int days, String path) throws Exception {
		Calendar now = Calendar.getInstance();
		Calendar after = Calendar.getInstance();
		Calendar before = Calendar.getInstance();
		now.setTime(start);
		before.setTime(start);
		now.add(Calendar.DAY_OF_YEAR, 1);
		before.add(Calendar.DAY_OF_YEAR, -1);
		after.setTime(now.getTime());
		now.setTime(start);
		for (int i = 0; i < days; i++) {
			
			String folderName = DateUtil.getFolderName(now.getTime());
			String fileName = DateUtil.getFileName(now.getTime()) + TYPE;
			String content = getContent(now, before, after);
			
			now.add(Calendar.DAY_OF_YEAR, 1);
			after.add(Calendar.DAY_OF_YEAR, 1);
			before.add(Calendar.DAY_OF_YEAR, 1);
			
			FileUtil.write(path + folderName, fileName, content);
		}
	}
	
	public String getContent(Calendar now,Calendar before,Calendar after) {
		StringBuffer sb = new StringBuffer();
		sb.append(String.format(TITLE, DateUtil.getTitle(now.getTime())));
		sb.append("\r\n");
		sb.append("\r\n");
		sb.append(README);
		sb.append("\r\n");
		sb.append(String.format(BEFORE, DateUtil.getFolderName(before.getTime()), DateUtil.getFileName(before.getTime())));
		sb.append("\r\n");
		sb.append(String.format(AFTER, DateUtil.getFolderName(after.getTime()), DateUtil.getFileName(after.getTime())));
		sb.append("\r\n");
		sb.append("\r\n");
		sb.append(TASK);
		return sb.toString();
	}
	

}
