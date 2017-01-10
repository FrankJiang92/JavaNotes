package notegen.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

import notegen.logger.Log;

public class FileUtil {

	public static void write(String folderName, String fileName, String content) throws Exception {
		OutputStream os = null;
		try {
			File file = new File(folderName);
			if (!file.exists()) {
				file.mkdirs();
			}
			file = new File(folderName + File.separator + fileName);
			if (!file.isDirectory() && !file.exists()) {
				file.createNewFile();
			}
			
			byte[] contentBytes = content.getBytes("UTF-8");
			os = new FileOutputStream(file);
			os.write(contentBytes);
			os.flush();
			os.close();
		} catch (Exception e) {
			Log.error("FileUtil write() error:", e);
			throw e;
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (Exception e2) {
				Log.error("FileUtil write() error: close outputstream error.");
			}
		}
	}
	
	public static void append(String folderName, String fileName, String content) throws Exception {
		try {
			File file = new File(folderName);
			if (!file.exists()) {
				file.mkdirs();
			}
			file = new File(folderName + File.separator + fileName);
			if (!file.exists()) {
				// 不存在，直接调用写方法
				FileUtil.write(folderName, fileName, content);
				return;
			}
			
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			raf.seek(raf.length());
			raf.writeBytes(content);
			raf.close();
		} catch (Exception e) {
			Log.error("FileUtil append() error:", e);
		}
	}
	
	public static void appendLine(String folderName, String fileName, String content) throws Exception {
		FileUtil.append(folderName, fileName, "\r\n" + content);
	}
 	
}
