package notegen.logger;

import java.util.logging.Level;

public class Log {

	public static final java.util.logging.Logger logger = java.util.logging.Logger.getGlobal();
	
	public static void info(String msg) {
		logger.log(Level.INFO, msg);
	}
	
	public static void info(String msg, Throwable e) {
		logger.log(Level.INFO, msg, e);
	}
	
	public static void warn(String msg) {
		logger.log(Level.WARNING, msg);
	}
	
	public static void warn(String msg, Throwable e) {
		logger.log(Level.WARNING, msg, e);
	}
	
	public static void error(String msg) {
		logger.log(Level.SEVERE, msg);
	}
	
	public static void error(String msg, Throwable e) {
		logger.log(Level.SEVERE, msg, e);
	}
}
