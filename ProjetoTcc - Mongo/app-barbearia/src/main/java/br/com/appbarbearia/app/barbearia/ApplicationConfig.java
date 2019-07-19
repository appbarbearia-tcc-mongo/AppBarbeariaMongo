package br.com.appbarbearia.app.barbearia;

import com.mongodb.MongoClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.appbarbearia.*")
class ApplicationConfig extends AbstractMongoConfiguration {

  @Autowired 
  MongoDbFactory mongoDbFactory;
  @Autowired 
  MongoMappingContext mongoMappingContext;

  @Override
  protected String getDatabaseName() {
    return "appbarbearia";
  }

  @Override
  protected String getMappingBasePackage() {
        return "br.com.appbarbearia";
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("127.0.0.1", 27017);
  }

  @Bean
  public MappingMongoConverter mappingMongoConverter() {
 
   DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
   MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
   converter.setTypeMapper(new DefaultMongoTypeMapper(null));
 
   return converter;
  }
}