package com.javahash.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.javahash.spring.service.IAccountsService;
import com.javahash.spring.service.IArticleService;
import com.javahash.spring.service.IEmployeesService;
import com.javahash.spring.service.IFooService;
import com.javahash.spring.service.impl.AccountsServiceImpl;
import com.javahash.spring.service.impl.ArticleServiceImpl;
import com.javahash.spring.service.impl.EmployeesServiceImpl;
import com.javahash.spring.service.impl.FooServiceImpl;

@Configuration
@ComponentScan(basePackages={"com.javahash.spring"})
@EnableWebMvc
@Import(DaoConfig.class)
public class AppConfiguration {
	
	@Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	@Bean(name="fooService")
	public IFooService getFooService() {
	    return new FooServiceImpl(); // We still need to inject someInterestingProperty
	}
	
	//@Bean(name="accountService")
	public IAccountsService getAccountService() {
	    return new AccountsServiceImpl(); // We still need to inject someInterestingProperty
	}
	
	//@Bean(name="articleService")
	public IArticleService getArticlesService() {
	    return new ArticleServiceImpl(); 
	}
	
	@Bean(name="employeesService")
	public IEmployeesService getEmployeesService() {
	    return new EmployeesServiceImpl(); 
	}
	
}
