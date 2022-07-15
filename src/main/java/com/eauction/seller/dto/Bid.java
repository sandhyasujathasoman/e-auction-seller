package com.eauction.seller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Bid Response Class is to handle data transfer
 *
 * @author Sandhya S S
 * @since 15/06/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bid implements Serializable {

    private static final long serialVersionUID = 955728933773177258L;

    private Integer id;
    private Integer productId;
    private String bidAmount;
    private Buyer buyer;
}
