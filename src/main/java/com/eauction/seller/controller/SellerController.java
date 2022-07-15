package com.eauction.seller.controller;

import com.eauction.seller.common.RestApiController;
import com.eauction.seller.dto.*;
import com.eauction.seller.model.Product;
import com.eauction.seller.model.Seller;
import com.eauction.seller.service.ProductService;
import com.eauction.seller.service.SellerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Seller Controller to perform seller actions
 *
 * @author Sandhya S S
 * @since 15/06/2022
 */
@Api(tags = "E-Auction Seller REST Controller")
@RestApiController("/e-auction/api/v1/seller")
@RequiredArgsConstructor
public class SellerController {

    @Autowired
    private ProductService productService;
    @Autowired
    private SellerService sellerService;

    /**
     * Returns all Products
     *
     * @return a {@link List} of type {@link Product}
     */
    @ApiOperation(value = "Show all Products", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Product.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @GetMapping("show-products")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    public ResponseEntity<Products> showProducts() {
        List<Product> productList = productService.getAllProducts();
        Products products = Products.builder().products(productList).build();
        return ResponseEntity.ok(products);
    }

    /**
     * Returns a Product for the given Product Id
     *
     * @param productId refers to attribute {@code id} of type {@link Product}
     * @return the requested product of type {@link Product}
     */
    @ApiOperation(value = "For [US_05] Show a Product for a given Product Id", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Product.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @GetMapping("show-products/{product-id}")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    public ResponseEntity<Product> showProduct(@PathVariable("product-id") Integer productId) {
        Product product = productService.getProduct(productId);
        return ResponseEntity.ok(product);
    }

    /**
     * Returns the newly added Product and Seller
     *
     * @param productSellerRequest of type {@link ProductSellerRequest}
     * @return the newly added product and seller of type {@link ProductResponse}
     */
    @ApiOperation(value = "[US_01] Adds a new Seller and Product", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Product.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @PostMapping("add-product")
    @ResponseBody
    public ResponseEntity<ProductResponse> addProduct(@RequestBody final ProductSellerRequest productSellerRequest) {
        Seller seller = sellerService.addSeller(productSellerRequest.getSeller());
        productSellerRequest.getProduct().setSellerId(seller.getId());
        Product product = productService.addProduct(productSellerRequest.getProduct());
        ProductResponse productResponse = ProductResponse.builder()
                .status(HttpStatus.OK)
                .product(product)
                .seller(seller)
                .build();
        return ResponseEntity.ok(productResponse);
    }

    /**
     * Returns the Product Details with Bids Placed
     *
     * @param productId refers to attribute {@code id} of type {@link Product}
     * @return the product response of type {@link ProductResponse}
     */
    @ApiOperation(value = "[US_04] Shows the Product details with the list of bids placed", response = ProductBidResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Product.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @GetMapping("/show-bids/{productId}")
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    public ResponseEntity<ProductBidResponse> showProductBids(@PathVariable("productId") Integer productId) {
        Product product = productService.getProduct(productId);
        Seller seller = sellerService.getSeller(product.getSellerId());
        List<Bid> bidsPlaced = productService.getProductBids(productId);
        if (CollectionUtils.isNotEmpty(bidsPlaced)) {
            Collections.sort(bidsPlaced, Comparator.comparing(Bid::getBidAmount).reversed());
        }
        ProductBidResponse productResponse = ProductBidResponse.builder()
                .status(HttpStatus.OK)
                .product(product)
                .seller(seller)
                .bidsPlaced(bidsPlaced)
                .build();
        return ResponseEntity.ok(productResponse);
    }

    /**
     * Deletes the given Product
     *
     * @param productId refers to attribute {@code id} of type {@link Product}
     */
    @ApiOperation(value = "[US_02] Deletes the given Product", response = HttpStatus.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Product.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @DeleteMapping("/delete/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("productId") Integer productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
