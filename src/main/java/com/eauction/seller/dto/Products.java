package com.eauction.seller.dto;

import com.eauction.seller.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Products Response Class is to handle data transfer
 *
 * @author Sandhya S S
 * @since 15/06/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Products implements Serializable {

    private static final long serialVersionUID = 955728933773179848L;

    private List<Product> products;
}
