package com.javahash.spring.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javahash.spring.model.Article;
import com.javahash.spring.service.IArticleService;
import com.javahash.spring.util.RestPreconditions;

@Profile("spring-rest")
//@RestController
@RequestMapping( value = "/articles" )
public class ArticlesController {
	
	@Autowired
	public IArticleService articleService;
	
	@RequestMapping( method = RequestMethod.POST )
	@ResponseStatus( HttpStatus.CREATED )
	public void create( @RequestBody Article resource ){
		System.out.println(resource + " init");
		RestPreconditions.checkNotNull( resource );
		articleService.create( );
		System.out.println(" created");
		
	}
	
	@RequestMapping( method = RequestMethod.GET )
	@ResponseStatus( HttpStatus.ACCEPTED )
	public @ResponseBody Iterable<Article> getAll(){
		Iterable<Article> articles = articleService.findAll();
		System.out.println(" get all articles ");
		return articles;
		
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.GET )
	public @ResponseBody Article findOne( @PathVariable( "id" ) String id ){
		return (Article) RestPreconditions.checkFound( articleService.findArticleById(id) );
	}
	
}
