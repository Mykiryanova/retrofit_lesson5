package retrofittest;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit.DTO.Product;
import retrofit.restapi.ProductService;
import retrofit.utils.RetrofitUtils;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

// В этом тесте будем менять стоимость хлеба
public class PutProductTest {
    static ProductService productService;
    Product product;
    Faker faker = new Faker();

    int price;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }

    @BeforeEach
    void setUp() {
        product = new Product()
                .withId(23656)
                .withTitle("Bread")
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 100));
    }

    @Test
    @SneakyThrows
    void modifyProductInFoodCategoryTest() {
        Response<Product> response = productService.putProduct(product)
                .execute();
        price = response.body().getPrice();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(23656));
        assertThat(response.body().getTitle(), equalTo("Bread"));
        assertThat(response.body().getCategoryTitle(), equalTo("Food"));
        System.out.println("Теперь хлеб стоит " + price + " рублей");
    }

}
