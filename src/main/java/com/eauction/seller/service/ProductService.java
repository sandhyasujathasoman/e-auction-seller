package com.eauction.seller.service;

import com.eauction.seller.model.Product;
import com.eauction.seller.dto.Bid;

import java.util.List;

/**
 * Product Service Interface to manage Product Details
 *
 * @author Sandhya S S
 * @since 15/06/2022
 */
public interface ProductService {

    /**
     * Returns all Products
     *
     * @return a list of {@link Product}
     */
    List<Product> getAllProducts();

    /**
     * Returns all Products for the given Seller
     *
     * @param sellerId refers to attribute {@code sellerId}
     * @return a list of {@link Product}
     */
    List<Product> getAllProducts(Integer sellerId);

    /**
     * Returns requested Product
     *
     * @param productId refers to attribute {@code id}
     * @return a {@link Product} identified by its id
     */
    Product getProduct(Integer productId);

    /**
     * Adds a new Product
     *
     * @param product refers to a new instance of {@link Product}
     * @return a newly added product of type {@link Product}
     */
    Product addProduct(Product product);

    /**
     * Deletes an existing Product
     *
     * @param productId refers to attribute {@code id}
     */
    void deleteProduct(Integer productId);

    /**
     * Returns list of Bids placed for the Product
     *
     * @param productId refers to attribute {@code id} of type {@link Product}
     * @return a {@link List} of {@link Bid} identified by its productId
     */
    List<Bid> getProductBids(Integer productId);
}
