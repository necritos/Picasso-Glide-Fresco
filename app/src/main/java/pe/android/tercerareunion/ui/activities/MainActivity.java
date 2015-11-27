package pe.android.tercerareunion.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pe.android.tercerareunion.R;
import pe.android.tercerareunion.model.CategoryEntity;
import pe.android.tercerareunion.request.PopKeyClient;
import pe.android.tercerareunion.request.ServiceGenerator;
import pe.android.tercerareunion.ui.adapters.CategoryAdapter;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends BaseActivity {


    private CategoryAdapter categoryAdapter;
    private RecyclerView rvListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvListView = (RecyclerView) findViewById(R.id.rv_list);
        rvListView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvListView.setLayoutManager(mLayoutManager);

        categoryAdapter = new CategoryAdapter(this, new ArrayList<CategoryEntity>());
        rvListView.setAdapter(categoryAdapter);


        PopKeyClient popKeyClient = ServiceGenerator.createService(PopKeyClient.class);
        Call<List<CategoryEntity>> call = popKeyClient.getCategories();
        call.enqueue(new Callback<List<CategoryEntity>>() {
            @Override
            public void onResponse(Response<List<CategoryEntity>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    populate(response.body());
                } else {
                    Log.d("Error", response.message());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

    }

    private void populate(List<CategoryEntity> categoryEntities)
    {
        categoryAdapter= new CategoryAdapter(this,categoryEntities);
        rvListView.setAdapter(categoryAdapter);
    }


}
