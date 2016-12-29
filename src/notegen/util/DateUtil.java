package notegen.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String PATTERN_FOLDER = "yyyyMM";
	public static String PATTERN_FILE = "yyyyMMdd";
	public static String PATTERN_TITLE = "yyyy-MM-dd";
	
	
	public static String getFolderName(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_FOLDER);
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
}
