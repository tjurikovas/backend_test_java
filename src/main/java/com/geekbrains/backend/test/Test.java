package com.geekbrains.backend.test;

import com.geekbrains.backend.test.miniMarket.MiniMarketService;

import com.geekbrains.backend.test.miniMarket.ObjectResponse;
import com.geekbrains.backend.test.miniMarket.ProductResponse;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        MiniMarketService service = new MiniMarketService();
        ProductResponse product = service.getProduct(32L);
        System.out.println(product);

        MiniMarketService service1 = new MiniMarketService();
        ObjectResponse object1 = service1.getProducts();
        System.out.println(object1);

        MiniMarketService service2 = new MiniMarketService();
        ObjectResponse object2 = service2.createProducts();
        System.out.println(object2);

        MiniMarketService service3 = new MiniMarketService();
        ObjectResponse object3 = service3.uptateProduct();
        System.out.println(object3);

        MiniMarketService service4 = new MiniMarketService();
        ObjectResponse object4 = service4.deleteProduct(177L);
        System.out.println(object4);
    }
}

