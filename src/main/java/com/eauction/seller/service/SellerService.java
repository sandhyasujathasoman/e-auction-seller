package com.eauction.seller.service;

import com.eauction.seller.model.Seller;

/**
 * Seller Service Interface to manage Seller Details
 *
 * @author Sandhya S S
 * @since 15/06/2022
 */
public interface SellerService {

    /**
     * Returns requested Seller
     *
     * @param sellerId refers to attribute {@code id}
     * @return a {@link Seller} identified by its id
     */
    Seller getSeller(Integer sellerId);

    /**
     * Adds a new Seller
     *
     * @param seller refers to a new instance of {@link Seller}
     * @return a newly added seller of type {@link Seller}
     */
    Seller addSeller(Seller seller);

    /**
     * Deletes an existing Seller
     *
     * @param sellerId refers to attribute {@code id}
     */
    void deleteSeller(Integer sellerId);
}
