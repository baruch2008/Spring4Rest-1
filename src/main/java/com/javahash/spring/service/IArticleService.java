package com.javahash.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.javahash.spring.model.Article;

public interface IArticleService {
	
	public Page<Article> findByAuthorsName();
	
	public Article findArticleById(String id);
	
	public Iterable<Article> findAll();
	
	public void create();

}
