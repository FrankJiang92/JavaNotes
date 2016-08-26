package freemarker;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.bean.UserBean;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class Freemarker {

	public static void main(String[] args) {
		
		try {
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
			cfg.setDirectoryForTemplateLoading(new File("html"));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			cfg.setLogTemplateExceptions(false);
			
			Map<String, Object> data = new HashMap<String, Object>();
			UserBean user = new UserBean();
			user.setName("Frank");
			user.setSexy("Boy");
			user.setAge(24);
			user.setSchool("Shanghai University");
			data.put("user", user);
			
			Template template = cfg.getTemplate("freemarker.html");
			
			Writer out = new OutputStreamWriter(System.out);
			template.process(data, out);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}
}
