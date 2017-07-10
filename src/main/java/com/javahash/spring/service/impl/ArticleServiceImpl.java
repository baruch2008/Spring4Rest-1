package com.javahash.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.javahash.spring.dao.ArticleRepository;
import com.javahash.spring.model.Article;
import com.javahash.spring.service.IArticleService;

public class ArticleServiceImpl implements IArticleService{
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public Page<Article> findByAuthorsName(){
		String nameToFind = "John Smith";
//		Page<Article> articleByAuthorName
//		  = articleRepository.findByAuthorsName(nameToFind, new PageRequest(0, 10));
		return null; //articleByAuthorName;
	}
	
	public void create(){
		Article article = new Article();
		article.setTitle("Mi novia katia");
		
		articleRepository.save(article);
	}

	public Article findArticleById(String id) {
		List<Article> articles = articleRepository.findArticlesById(id);
		System.out.println(articles + " id:[" + id + "]");
		if(articles != null && !articles.isEmpty()){
			return articles.get(0);
		}
		else{
			return null;
		}
	}

	public Iterable<Article> findAll() {
		Iterable <Article> articles = articleRepository.findAll();
		return articles;
	}
	
}
