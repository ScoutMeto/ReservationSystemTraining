package com.mykettlebellproject.ragnarokproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan("com.mykettlebellproject.ragnarokproject")
@EnableJpaRepositories("com.mykettlebellproject.ragnarokproject")
public class RagnarokprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RagnarokprojectApplication.class, args);
	}

}