package xyz.adrianosanges.template.configuration;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan
public class Log4JConfig {
		
		@Bean
		public ConsoleAppender consoleAppender(){
			ConsoleAppender consoleAppender=new ConsoleAppender();
			consoleAppender.setThreshold(org.apache.log4j.Level.ALL);
			PatternLayout patternLayout=new PatternLayout();
			patternLayout.setConversionPattern("[%p] %d %c %M - %m%n");
			//Layout patternLayout=new PatternLayout("[%p] %d %c %M - %m%n");
			
			consoleAppender.setLayout(patternLayout);
			return consoleAppender;
		}
		
//		@Bean
//		public FileAppender fileAppender(){
//			FileAppender fileAppender=new FileAppender();
//			fileAppender.setThreshold(org.apache.log4j.Level.DEBUG);
//			PatternLayout patternLayout=new PatternLayout();
//			patternLayout.setConversionPattern("[%p] %d %c %M - %m%n");
//			fileAppender.setLayout(patternLayout);
//			return fileAppender;
//		}
		
}
