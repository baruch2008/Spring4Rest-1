package com.javahash.spring.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.javahash.spring.dao")
public class DaoConfig {
 
    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() {
    	return new ElasticsearchTemplate(getNodeClientIP());
    }
    
    private static Client getNodeClientIP() {
    	
    	Settings settings = ImmutableSettings.settingsBuilder()
    			.put("client.transport.ping_timeout", "15s")
    	        .put("client.transport.sniff", false)
    	        .put("client.transport.nodes_sampler_interval", "15s")
    	        .put("cluster.name", "elasticsearch")
    	        .build();
    	
   	
    	Client client = new TransportClient(settings)
        .addTransportAddress(new InetSocketTransportAddress("127.0.0.1", 9300));
    	
    	return client;
    }
 
}