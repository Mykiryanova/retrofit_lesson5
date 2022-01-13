package retrofit.restapi;

import okhttp3.ResponseBody;
import retrofit.DTO.Product;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ProductService {
    @POST("products")
    Call<Product> createProduct(@Body Product createProductRequest);

    @DELETE ("products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") int id);

    @GET("products/{id}")
    Call<Product> getProduct (@Path("id") int id);

    @GET("products")
    Call<Product> getProducts();

    @PUT("products")
    Call<Product> putProduct(@Body Product putProductRequest);


}
