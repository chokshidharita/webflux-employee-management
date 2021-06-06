package com.management.employee.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.management.employee.dao")
public class MongoDBConfig extends AbstractReactiveMongoConfiguration {

    @Value("${dbname}")
    private String dbName;

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create(
                "mongodb+srv://admin:rootAccess@cluster0.k4aaz.mongodb.net/employeeManagement?retryWrites=true&w=majority");
    }

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
    }
}
