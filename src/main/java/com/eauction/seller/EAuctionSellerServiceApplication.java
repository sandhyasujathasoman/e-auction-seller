package com.eauction.seller;

import com.eauction.seller.config.BuyerServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@EnableDiscoveryClient
@EnableFeignClients
@EnableConfigurationProperties({
		BuyerServiceConfig.class
})
public class EAuctionSellerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EAuctionSellerServiceApplication.class, args);
	}

}


