package com.geekbrains.backend.test.miniMarket;



import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

public class MiniMarketRetrofitTest {
    static MiniMarketApi miniMarketApi;

    @BeforeAll
    static void beforeAll() {
        miniMarketApi = MiniMarketService.getRetrofit().create(MiniMarketApi.class);
    }

    @SneakyThrows
    @Test
    void getCategoryById() {
        Response<Product> response = miniMarketApi.getProduct(88L).execute();
        assert (response.isSuccessful());
        assert (response.body().getTitle().equals("Smartphone"));
        assert (response.body().getCategoryTitle().equals("Electronic"));
    }
    @SneakyThrows
    @Test
    void modifyProduct() {
        Product product = new Product(176L,"Photo_camera", (int) (Math.random() * 10000),"Electronic");
        Response<Object> response = miniMarketApi.updateProduct(product).execute();
        assert (response.isSuccessful());
    }
}
