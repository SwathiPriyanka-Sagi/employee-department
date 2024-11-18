package com.entity.EmpDept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="com.tracxe.dao")
@EntityScan(basePackages="com.trx.model")
@SpringBootApplication(scanBasePackages="com")
public class EmpDeptApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EmpDeptApplication.class, args);
	}

}
