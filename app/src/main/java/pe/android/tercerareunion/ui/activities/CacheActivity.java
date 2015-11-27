package pe.android.tercerareunion.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import pe.android.tercerareunion.R;

/**
 * Created by manu on 27/11/15.
 */
public class CacheActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transform);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Picasso.with(this)
                .setIndicatorsEnabled(true);

        ImageView image1 = (ImageView)findViewById(R.id.iv_one);
        Picasso.with(this)
                .load("http://cdn2.larepublica.pe/sites/default/files/styles/img_620x369/public/imagen/2015/08/18/andr-Noticia-399494.jpg")
                .placeholder(R.drawable.placeholder)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(image1);

        ImageView image2 = (ImageView) findViewById(R.id.iv_two);
        Picasso.with(this)
                .load("http://cde.peru.com/ima/0/0/9/9/3/993570/611x458/android.jpg")
                .placeholder(R.drawable.placeholder)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                .into(image2);

        ImageView image3 = (ImageView)findViewById(R.id.iv_three);
        Picasso.with(this)
                .load("http://pcworld.pe/wp-content/uploads/2013/07/android_jelly_bean_louis_gray_1_610x45-100005501-large.jpg")
                .placeholder(R.drawable.placeholder)
                .into(image3);

        ImageView image4 = (ImageView)findViewById(R.id.iv_four);
        Picasso.with(this)
                .load("http://pcworld.pe/wp-content/uploads/2013/07/android_jelly_bean_louis_gray_1_610x45-100005501-large.jpg")
                .placeholder(R.drawable.placeholder)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(image4);
    }
}
