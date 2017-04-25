package notegen.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static String PATTERN_FOLDER = "yyyyMM";
	public static String PATTERN_MONTH_TITLE = "yyyy-MM";
	public static String PATTERN_FILE = "yyyyMMdd";
	public static String PATTERN_TITLE = "yyyy-MM-dd";
	
	
	
	public static String getFolderName(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_FOLDER);
		return sdf.format(date);
	}
	
	public static String getMonthTitle(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_MONTH_TITLE);
		return sdf.format(date);
	}
	
	public static String getFileName(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_FILE);
		return sdf.format(date);
	}
	
	public static String getTitle(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_TITLE);
		return sdf.format(date);
	}
	
	public static String getFolderName(Calendar calendar) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_FOLDER);
		return sdf.format(calendar.getTime());
	}
	
	public static String getMonthTitle(Calendar calendar) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_MONTH_TITLE);
		return sdf.format(calendar.getTime());
	}
	
	public static String getFileName(Calendar calendar) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_FILE);
		return sdf.format(calendar.getTime());
	}
	
	public static String getTitle(Calendar calendar) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_TITLE);
		return sdf.format(calendar.getTime());
	}
	
	
}
