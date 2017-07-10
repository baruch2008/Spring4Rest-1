package com.javahash.spring.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.javahash.spring.model.Article;

public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
	 
    //Page<Article> findByAuthorsName(String name, Pageable pageable);
 
    @Query("{\"bool\": {\"must\": [{\"match\": {\"title\": \"?0\"}}]}}")
    Page<Article> findByTitleUsingCustomQuery(String title, Pageable pageable);
    
    @Query("{\"bool\": {\"must\": [{\"match\": {\"id\": \"?0\"}}]}}")
    List<Article> findArticlesById(String id); 
    
}
