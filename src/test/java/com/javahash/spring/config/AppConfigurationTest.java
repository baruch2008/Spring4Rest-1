package com.javahash.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.javahash.spring.service.IArticleService;
import com.javahash.spring.service.impl.ArticleServiceImpl;

@Configuration
@ComponentScan(basePackages={"com.javahash.spring"})
//@Import(DaoConfig.class)
public class AppConfigurationTest {
		
	@Bean(name="articleService")
	public IArticleService getArticlesService() {
	    return new ArticleServiceImpl(); 
	}
	
}

