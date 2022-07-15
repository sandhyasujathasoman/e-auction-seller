package com.eauction.seller.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Buyer Service Configuration class
 *
 * @author Sandhya S S
 * @since 15/06/2022
 */
@Data
@ConfigurationProperties(prefix = "app.services.buyer-service")
public class BuyerServiceConfig {
    private String scheme;
    private String host;
    private Integer port = -1;
    private String bidSearch;
}
