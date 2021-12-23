package com.geekbrains.backend.test.miniMarket;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MiniMarketService {

    private final MiniMarketApi api;

    public MiniMarketService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://minimarket1.herokuapp.com/market/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(MiniMarketApi.class);
    }

    public ProductResponse getProduct(Long id) throws IOException {
        Response<Product> response = api.getProduct(id).execute();
        ProductResponse productResponse = new ProductResponse();
        if (response.isSuccessful()) {
            productResponse.setProduct(response.body());
        } else {
            productResponse.setError(response.errorBody().string());
        }
        return productResponse;
    }

    public ObjectResponse getProducts () throws IOException {
        Response<List<Product>> response = api.getProducts().execute();
        ObjectResponse objectResponse = new ObjectResponse();
        if (response.isSuccessful()) {
            objectResponse.setObject(response.body());
        } else {
            objectResponse.setError(response.errorBody().toString());
        }
        return objectResponse;
    }

    public ObjectResponse createProducts() throws IOException {
        Product product = new Product(null,"Smartphone", 993,"Electronc");
        Response<Object> response = api.createProduct(product).execute();
        ObjectResponse objectResponse = new ObjectResponse();
        if (response.isSuccessful()) {
            objectResponse.setObject(response.body());
    } else {
            objectResponse.setError(response.errorBody().string());
        }
        return objectResponse;
    }

    public ObjectResponse uptateProduct() throws IOException {
        Product product = new Product(175L,"Tablet", (int) (Math.random() * 10000),"Electronic");
        Response<Object> response = api.updateProduct(product).execute();
        ObjectResponse objectResponse = new ObjectResponse();
        if (response.isSuccessful()) {
            objectResponse.setObject(response.body());
        } else {
            objectResponse.setError(response.errorBody().string());
        }
        return objectResponse;
    }

    public ObjectResponse deleteProduct(Long id) throws IOException {
        Response<Object> response = api.deleteProduct(id).execute();
        ObjectResponse objectResponse = new ObjectResponse();
        if (response.code() == 200) {
            objectResponse.setObject(response.headers());
        } else {
            objectResponse.setError(response.errorBody().string());
        }
        return objectResponse;
    }

    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://minimarket1.herokuapp.com/market/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}