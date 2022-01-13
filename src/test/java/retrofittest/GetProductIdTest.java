package retrofittest;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit.DTO.Product;
import retrofit.restapi.ProductService;
import retrofit.utils.RetrofitUtils;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetProductIdTest {
    static ProductService productService;
    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }

    @Test
    @SneakyThrows
    void getProductWithResponseAssertionsPositiveTest() {
        Response<Product> response = productService.getProduct(19693).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(19693));
        assertThat(response.body().getTitle(), equalTo("Oranges"));
        assertThat(response.body().getPrice(), equalTo(172));
        assertThat(response.body().getCategoryTitle(), equalTo("Food"));

    }
    }






