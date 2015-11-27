package pe.android.tercerareunion.request;

import java.util.List;

import pe.android.tercerareunion.model.CategoryEntity;
import retrofit.Call;
import retrofit.http.GET;

public interface PopKeyClient {
    @GET("v2/categories?type=featured")
    Call<List<CategoryEntity>> getCategories();
}