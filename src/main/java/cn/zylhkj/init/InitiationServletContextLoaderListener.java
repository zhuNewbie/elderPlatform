package cn.zylhkj.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class InitiationServletContextLoaderListener implements ServletContextListener {

	private static final Log log = LogFactory.getLog(InitiationServletContextLoaderListener.class);
	  
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		log.debug("应用程序初始化 ...");
		System.out.println("应用程序初始化 ...");
		
	    ServletContext servletContext = event.getServletContext();
	    SystemContext.setApplicationContext(WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext));
	    System.out.println(SystemContext.getApplicationContext());
	    System.out.println(WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext));
	}

}
