package xyz.adrianosanges.template.configuration;

import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.multipart.support.MultipartFilter;

public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
   
	//enctype multipart support
	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext){
		insertFilters (servletContext,new MultipartFilter());
	}
}