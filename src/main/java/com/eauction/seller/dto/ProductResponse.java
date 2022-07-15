package com.eauction.seller.dto;

import com.eauction.seller.model.Product;
import com.eauction.seller.model.Seller;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

/**
 * Product Response Class is to handle data transfer
 *
 * @author Sandhya S S
 * @since 15/06/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse implements Serializable {

    private static final long serialVersionUID = 955728933773177448L;

    private HttpStatus status;
    private Product product;
    private Seller seller;
    @JsonInclude(Include.NON_NULL)
    private List<Bid> bidsPlaced;
}
