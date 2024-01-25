package com.bikeshop.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.bikeshop.common.entity", "com.bikeshop.admin.user"})
public class BikeShopBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikeShopBackendApplication.class, args);
	}

}
