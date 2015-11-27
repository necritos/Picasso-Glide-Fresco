package pe.android.tercerareunion.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

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

public class MainActivity extends AppCompatActivity {


    List<CategoryEntity> categoryEntityList= new ArrayList<>();
    private CategoryAdapter categoryAdapter;
    private RecyclerView rvListView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvListView = (RecyclerView) findViewById(R.id.rv_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        rvListView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        rvListView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
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
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });

    }

    private void populate(List<CategoryEntity> categoryEntities)
    {
        categoryAdapter= new CategoryAdapter(this,categoryEntities);
        rvListView.setAdapter(categoryAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
