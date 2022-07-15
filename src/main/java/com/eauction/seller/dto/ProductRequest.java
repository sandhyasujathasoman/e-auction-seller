package com.eauction.seller.dto;

import com.eauction.seller.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Product Request Class is to handle data transfer
 *
 * @author Sandhya S S
 * @since 15/06/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private Product product;
}
