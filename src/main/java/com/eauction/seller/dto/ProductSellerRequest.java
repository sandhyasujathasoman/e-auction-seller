package com.eauction.seller.dto;

import com.eauction.seller.model.Product;
import com.eauction.seller.model.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Product and Seller Request Class is to handle data transfer
 *
 * @author Sandhya S S
 * @since 15/06/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSellerRequest {

    private Product product;
    private Seller seller;
}
