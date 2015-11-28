package pe.android.tercerareunion.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


import pe.android.tercerareunion.R;
import pe.android.tercerareunion.utils.BlurTransformation;
import pe.android.tercerareunion.utils.CircleTransform;
import pe.android.tercerareunion.utils.RoundedCornersTransformation;

public class TransformActivity extends BaseActivity {


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
                .bitmapTransform(new RoundedCornersTransformation(this, 80, 0))
                .into(image1);

        ImageView image2 = (ImageView)findViewById(R.id.iv_two);
        Glide.with(this)
                .load("http://cdn2.larepublica.pe/sites/default/files/styles/img_620x369/public/imagen/2015/08/18/andr-Noticia-399494.jpg")
                .crossFade()
                .override(300, 300)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .bitmapTransform(new CircleTransform(this))
                .into(image2);

        ImageView image3 = (ImageView)findViewById(R.id.iv_three);
        Glide.with(this)
                .load("http://cdn2.larepublica.pe/sites/default/files/styles/img_620x369/public/imagen/2015/08/18/andr-Noticia-399494.jpg")
                .placeholder(R.drawable.placeholder)
                .bitmapTransform(new RoundedCornersTransformation(this, 30, 0,
                        RoundedCornersTransformation.CornerType.BOTTOM))
                .thumbnail(0.1f)
                .into(image3);

        ImageView image4 = (ImageView)findViewById(R.id.iv_four);
        Glide.with(this)
                .load("http://cdn2.larepublica.pe/sites/default/files/styles/img_620x369/public/imagen/2015/08/18/andr-Noticia-399494.jpg")
                .placeholder(R.drawable.placeholder)
                .bitmapTransform(new BlurTransformation(this))
                .into(image4);
    }




}
