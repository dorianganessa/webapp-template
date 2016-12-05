package xyz.adrianosanges.template.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcInitializer 
extends AbstractAnnotationConfigDispatcherServletInitializer {

@Override
protected Class<?>[] getRootConfigClasses() {
	return new Class[] { RootConfiguration.class};
}

@Override
protected Class<?>[] getServletConfigClasses() {
	return null; //new Class<?>[] { AppConfig.class };
}

@Override
protected String[] getServletMappings() {
	return new String[] { "/" };
}

@Override
public void onStartup(ServletContext servletContext) throws ServletException {
    super.onStartup(servletContext);
    servletContext.addListener(new SessionListener());
}
}