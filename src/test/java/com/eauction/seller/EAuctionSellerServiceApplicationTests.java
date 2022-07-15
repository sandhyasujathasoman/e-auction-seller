package com.eauction.seller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.eauction.seller.EAuctionSellerServiceApplication;

@SpringBootTest
class EAuctionSellerServiceApplicationTests {

    @Test
    void test_main() {
        EAuctionSellerServiceApplication.main(new String[]{"spring.profiles.active=test"});
        Assertions.assertTrue(true);
    }
}
