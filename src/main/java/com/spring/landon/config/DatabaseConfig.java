package com.spring.landon.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.spring.landon.repository")
@EnableTransactionManagement
public class DatabaseConfig {

}
