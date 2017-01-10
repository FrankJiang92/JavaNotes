package notegen.main;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import notegen.logger.Log;
import notegen.util.DateUtil;
import notegen.util.FileUtil;

public class Notegen {

	public static String TYPE = ".md";
	public static String TITLE = "### %s";
	public static String README_OF_DAY = "* [列表目录](../README.md)";
	public static String CALENDAR_OF_DAY = "* [日历目录](../Calendar.md)";
	public static String BEFORE_OF_DAY = "* [ 前一天 ](../%s/%s.md)";
	public static String AFTER_OF_DAY = "* [ 后一天 ](../%s/%s.md)";
	public static String TASK_OF_DAY = "> 工作任务";
	
	public static String README_OF_MONTH = "* [列表目录](README.md)";
	public static String CALENDAR_OF_MONTH = "* [日历目录](Calendar.md)";
	
	public static String DAY_OF_MONTH = "* [%s](%s/%s.md)\r\n";
	
	public static String README_FILE_NAME = "README.md";
	public static String CALENDAR_FILE_NAME = "Calendar.md";
	public static String MONTH_OF_README = "* [%s](%s.md)\r\n";
	public static String DAY_OF_CALENDAR = "[%d](%s/%s.md)";
	
	public static String SAVE_PATH = "E:/WorkNote/";
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("输入生成note的天数:");
		int days = scan.nextInt();
		System.out.println("正在生成......");
		Notegen gen = new Notegen();
		gen.generateNote(days);
		System.out.println("生成完成，保存在E:/WorkNote/");
		scan.close();
	}
	
	
	public void generateNote(int days) {
		Date date = new Date();
		try {
			generateNoteOfDay(date, days, SAVE_PATH);
		} catch (Exception e) {
			Log.error("generateNote error:", e);
		}
	}
	
	public void generateNoteOfDay(Date start, int days, String path) throws Exception {
		Calendar now = Calendar.getInstance();
		Calendar after = Calendar.getInstance();
		Calendar before = Calendar.getInstance();
		now.setTime(start);
		before.setTime(start);
		now.add(Calendar.DAY_OF_YEAR, 1);
		before.add(Calendar.DAY_OF_YEAR, -1);
		after.setTime(now.getTime());
		now.setTime(start);
		// 写readme
		String readmeContent = generateStartContentOfReadme();
		String calendarContent = generateStartContentOfCalendar();
		FileUtil.write(path, README_FILE_NAME, readmeContent);
		FileUtil.write(path, CALENDAR_FILE_NAME, calendarContent);
		for (int i = 0; i < days; i++) {
			
			String folderName = DateUtil.getFolderName(now.getTime());
			String fileName = DateUtil.getFileName(now.getTime()) + TYPE;
			String monthFileName = DateUtil.getFolderName(now) + TYPE;
			String content = getContent(now, before, after);
			String monthContent = null;
			if (i == 0 || before.get(Calendar.MONTH) != now.get(Calendar.MONTH)) {
				monthContent = generateStartContentStartOfMonth(now);
				FileUtil.write(path, monthFileName, monthContent);
				FileUtil.appendLine(path, README_FILE_NAME, generateContentOfReadme(now));
				FileUtil.appendLine(path, CALENDAR_FILE_NAME, generateContentOfReadme(now) + "\r\n");
				FileUtil.appendLine(path, CALENDAR_FILE_NAME, generateCalendarTableHeader() + "\r\n");
				FileUtil.append(path, CALENDAR_FILE_NAME, generateCalendarContent(now, true));
			} else {
				FileUtil.append(path, CALENDAR_FILE_NAME, generateCalendarContent(now, false));
			}
			monthContent = genearteContentOfMonth(now);
			
			now.add(Calendar.DAY_OF_YEAR, 1);
			after.add(Calendar.DAY_OF_YEAR, 1);
			before.add(Calendar.DAY_OF_YEAR, 1);
			
			// 写每天的文件头
			FileUtil.write(path + folderName, fileName, content);
			// 追加每月的文件
			FileUtil.appendLine(path, monthFileName, monthContent);
		}
	}
	
	


	public String getContent(Calendar now,Calendar before,Calendar after) {
		StringBuffer sb = new StringBuffer();
		sb.append(String.format(TITLE, DateUtil.getTitle(now)));
		sb.append("\r\n");
		sb.append("\r\n");
		sb.append(README_OF_DAY);
		sb.append("\r\n");
		sb.append(CALENDAR_OF_DAY);
		sb.append("\r\n");
		sb.append(String.format(BEFORE_OF_DAY, DateUtil.getFolderName(before), DateUtil.getFileName(before)));
		sb.append("\r\n");
		sb.append(String.format(AFTER_OF_DAY, DateUtil.getFolderName(after), DateUtil.getFileName(after)));
		sb.append("\r\n");
		sb.append("\r\n");
		sb.append(TASK_OF_DAY);
		return sb.toString();
	}
	
	public String generateStartContentStartOfMonth(Calendar now) {
		StringBuffer sb = new StringBuffer();
		sb.append(String.format(TITLE, DateUtil.getFolderName(now)));
		sb.append("\r\n");
		sb.append("\r\n");
		sb.append(README_OF_MONTH);
		sb.append("\r\n");
		sb.append(CALENDAR_OF_MONTH);
		sb.append("\r\n");
		sb.append("\r\n");
		sb.append("---");
		sb.append("\r\n");
		return sb.toString();
	}
	
	public String genearteContentOfMonth(Calendar now) {
		return String.format(DAY_OF_MONTH, DateUtil.getFileName(now), DateUtil.getFolderName(now), DateUtil.getFileName(now));
	}
	
	public String generateStartContentOfReadme() {
		StringBuffer sb = new StringBuffer();
		sb.append("## 工作记录");
		sb.append("\r\n");
		sb.append("\r\n");
		sb.append("---");
		sb.append("\r\n");
		sb.append("\r\n");
		sb.append(CALENDAR_OF_MONTH);
		sb.append("\r\n");
		sb.append("\r\n");
		sb.append("### 目录");
		sb.append("\r\n");
		return sb.toString();
	}
	
	public String generateContentOfReadme(Calendar now) {
		return String.format(MONTH_OF_README, DateUtil.getFolderName(now), DateUtil.getFolderName(now));
	}
	
	public String generateStartContentOfCalendar() {
		StringBuffer sb = new StringBuffer();
		sb.append("## 工作记录");
		sb.append("\r\n");
		sb.append("\r\n");
		sb.append("---");
		sb.append("\r\n");
		sb.append("\r\n");
		sb.append(README_OF_MONTH);
		sb.append("\r\n");
		sb.append("\r\n");
		sb.append("### 目录");
		sb.append("\r\n");
		
		return sb.toString();
	}
	
	public String generateCalendarTableHeader() {
		StringBuffer sb = new StringBuffer();
		sb.append("| Sun || Mon || Tue || Wes || Thu || Fri || Sat |");
		sb.append("\r\n");
		sb.append("| :--: || :--: || :--: || :--: || :--: || :--: || :--: |");
		return sb.toString();
	}
	
	public String generateCalendarContent(Calendar now, boolean isStart) {
		StringBuffer sb = new StringBuffer();
		int day = now.get(Calendar.DAY_OF_MONTH);
		String folder = DateUtil.getFolderName(now);
		String fileName = DateUtil.getFileName(now);
		int weekDay = now.get(Calendar.DAY_OF_WEEK);
		if (isStart) {
			for(int i = 0; i < weekDay - 1; i++) {
				sb.append("| |");
			}
		}
		sb.append("|");
		sb.append(String.format(DAY_OF_CALENDAR, day, folder, fileName));
		sb.append("|");
		if (weekDay == 7) {
			sb.append("\r\n");
		}
		return sb.toString();
	}

}
