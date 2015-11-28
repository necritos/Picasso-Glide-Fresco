package pe.android.tercerareunion.ui.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;

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
        //imagePipeline.clearMemoryCaches();
        //imagePipeline.clearDiskCaches();
        //imagePipeline.clearCaches();

        SimpleDraweeView image1 = (SimpleDraweeView)findViewById(R.id.iv_one);
        Uri uri = Uri.parse("http://cdn2.larepublica.pe/sites/default/files/styles/img_620x369/public/imagen/2015/08/18/andr-Noticia-399494.jpg");
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        boolean inMemoryCache = imagePipeline.isInBitmapMemoryCache(uri);
        if(inMemoryCache){
            image1.setImageURI(uri);
        }





        SimpleDraweeView image2 = (SimpleDraweeView) findViewById(R.id.iv_two);

        Uri uri2 = Uri.parse("http://pcworld.pe/wp-content/uploads/2013/07/android_jelly_bean_louis_gray_1_610x45-100005501-large.jpg");
        imagePipeline.evictFromMemoryCache(uri2);
        imagePipeline.evictFromDiskCache(uri2);
        image2.setImageURI(uri);





    }
}
