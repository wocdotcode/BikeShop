package com.bikeshop.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@SpringBootApplication
@EntityScan({"com.bikeshop.common.entity", "com.bikeshop.admin.user"})
public class BikeShopBackendApplication {
	public static void main(String[] args) {
		//System.setProperty("spring.mvc.pathmatch.matching-strategy", "ant_path_matcher");
		SpringApplication.run(BikeShopBackendApplication.class, args);
	}

}
