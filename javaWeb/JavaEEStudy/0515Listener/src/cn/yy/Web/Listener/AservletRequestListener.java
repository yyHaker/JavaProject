package cn.yy.Web.Listener;
/**
 * servletContext生命周期监听器
 */
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AservletRequestListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("servletContext begins to run");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
              System.out.println("servlstContext is destroyed");
	}

}
