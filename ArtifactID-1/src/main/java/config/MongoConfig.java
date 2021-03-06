package config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
 
import com.mongodb.MongoClient;

import aspect.logAspect;

@Configuration
@ComponentScan(basePackages = "query")
@EnableMongoRepositories({ "repository" })
@EnableAspectJAutoProxy
public class MongoConfig {
		@Bean
	    public MongoDbFactory mongoDbFactory() throws Exception {
	        MongoClient mongoClient = new MongoClient("localhost", 27017);
	        return new SimpleMongoDbFactory(mongoClient, "dataUserCard");
	    }
	 
	    @Bean
	    public MongoTemplate mongoTemplate() throws Exception {
	        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
	        return mongoTemplate;
	    }
	 
	    @Bean
	    public logAspect loggingAspect() {
	    	return new logAspect();
	    }
}
