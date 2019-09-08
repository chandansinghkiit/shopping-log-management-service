package com.mystyle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.mystyle.log.management.config.CassandraConfig;
import com.mystyle.log.management.config.WebConfig;

@SpringBootApplication
@EnableDiscoveryClient
@Import({WebConfig.class, CassandraConfig.class})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ShoppingLogManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingLogManagementServiceApplication.class, args);
	}

}
