package pe.android.tercerareunion.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

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
        Picasso.with(this)
                .load("http://cdn2.larepublica.pe/sites/default/files/styles/img_620x369/public/imagen/2015/08/18/andr-Noticia-399494.jpg")
                .placeholder(R.drawable.placeholder)
                .transform(new RoundedCornersTransformation(30, 0,
                        RoundedCornersTransformation.CornerType.BOTTOM_LEFT))
                .into(image1);

        ImageView image2 = (ImageView)findViewById(R.id.iv_two);
        Picasso.with(this)
                .load("http://cdn2.larepublica.pe/sites/default/files/styles/img_620x369/public/imagen/2015/08/18/andr-Noticia-399494.jpg")
                .resize(180, 180)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .transform(new CircleTransform())
                .into(image2);

        ImageView image3 = (ImageView)findViewById(R.id.iv_three);
        Picasso.with(this)
                .load("http://cdn2.larepublica.pe/sites/default/files/styles/img_620x369/public/imagen/2015/08/18/andr-Noticia-399494.jpg")
                .placeholder(R.drawable.placeholder)
                .transform(new RoundedCornersTransformation(120, 0,
                        RoundedCornersTransformation.CornerType.DIAGONAL_FROM_TOP_LEFT))
                .transform(new RoundedCornersTransformation(120, 0,
                        RoundedCornersTransformation.CornerType.DIAGONAL_FROM_TOP_RIGHT))
                .rotate(45f)
                .into(image3);

        ImageView image4 = (ImageView)findViewById(R.id.iv_four);
        Picasso.with(this)
                .load("http://cdn2.larepublica.pe/sites/default/files/styles/img_620x369/public/imagen/2015/08/18/andr-Noticia-399494.jpg")
                .placeholder(R.drawable.placeholder)
                .transform(new BlurTransformation(this))

                .into(image4);
    }




}
