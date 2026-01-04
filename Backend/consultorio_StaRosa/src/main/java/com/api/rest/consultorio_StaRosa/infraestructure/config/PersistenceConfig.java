package com.api.rest.consultorio_StaRosa.infraestructure.config;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.api.rest.consultorio_StaRosa.infraestructure.adapter.out.persistence.repository")
@EntityScan(basePackages = "com.api.rest.consultorio_StaRosa.infraestructure.adapter.out.persistence.entity")
public class PersistenceConfig {
    
}
