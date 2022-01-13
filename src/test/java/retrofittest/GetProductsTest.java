package retrofittest;

import javafx.beans.binding.BooleanExpression;
import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit.DTO.Product;
import retrofit.restapi.ProductService;
import retrofit.utils.RetrofitUtils;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetProductsTest {
    static ProductService productService;
    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }

    @Test
    @SneakyThrows
    void getProductsWithResponseAssertionsNegativeTest() {
        Response<Product> response = productService.getProducts().execute();
        assertEquals(response.code(), 500);
            }




}
