package pe.android.tercerareunion.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

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

        ImageView image1 = (ImageView)findViewById(R.id.iv_one);
        Glide.with(this)
                .load("http://cdn2.larepublica.pe/sites/default/files/styles/img_620x369/public/imagen/2015/08/18/andr-Noticia-399494.jpg")
                .placeholder(R.drawable.placeholder)
                .priority(Priority.LOW)
                .into(image1);

        ImageView image2 = (ImageView) findViewById(R.id.iv_two);
        Glide.with(this)
                .load("https://media.giphy.com/media/GW2GWfbcCNRzq/giphy.gif")
                .asGif()
                .crossFade()
                .placeholder(R.drawable.placeholder)
                .into(image2);

        ImageView image3 = (ImageView) findViewById(R.id.iv_three);
        Glide.with(this)
                .load("http://pcworld.pe/wp-content/uploads/2013/07/android_jelly_bean_louis_gray_1_610x45-100005501-large.jpg")
                .diskCacheStrategy( DiskCacheStrategy.NONE)
                .skipMemoryCache( true )
                .placeholder(R.drawable.placeholder)
                .into(image3);

        ImageView image4 = (ImageView)findViewById(R.id.iv_four);
        Glide.with(this)
                .load("http://pcworld.pe/wp-content/uploads/2013/07/android_jelly_bean_louis_gray_1_610x45-100005501-large.jpg")
                .placeholder(R.drawable.placeholder)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(image4);
    }
}
