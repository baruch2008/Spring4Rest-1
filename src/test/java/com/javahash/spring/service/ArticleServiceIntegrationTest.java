package com.javahash.spring.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javahash.spring.config.AppConfigurationTest;
import com.javahash.spring.model.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfigurationTest.class)
public class ArticleServiceIntegrationTest {

      @Autowired
      private IArticleService articleService;

      @Test
      public void testService() {
        Article article = articleService.findArticleById("123456");
        assertTrue(article != null);
      }
}