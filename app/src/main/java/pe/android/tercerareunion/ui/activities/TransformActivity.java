package pe.android.tercerareunion.ui.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import pe.android.tercerareunion.R;

public class TransformActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transform);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SimpleDraweeView image1 = (SimpleDraweeView)findViewById(R.id.iv_one);
        image1.setImageURI(Uri.parse("http://cdn2.larepublica.pe/sites/default/files/styles/img_620x369/public/imagen/2015/08/18/andr-Noticia-399494.jpg"));
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setBorder(R.color.colorPrimary, 1.0f);
        roundingParams.setRoundAsCircle(true);
        image1.getHierarchy().setRoundingParams(roundingParams);



        SimpleDraweeView image2 = (SimpleDraweeView)findViewById(R.id.iv_two);

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(
                Uri.parse("http://cdn2.larepublica.pe/sites/default/files/styles/img_620x369/public/imagen/2015/08/18/andr-Noticia-399494.jpg"))
                .setProgressiveRenderingEnabled(true)
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(image2.getController())
                .build();
        image2.setController(controller);




        SimpleDraweeView image3 = (SimpleDraweeView)findViewById(R.id.iv_three);


        DraweeController controllerImg3 = Fresco.newDraweeControllerBuilder()
                .setLowResImageRequest(ImageRequest.fromUri(Uri.parse("http://www.expresscopy.com/blog/wp-content/uploads/2012/08/Sunflower_small.jpg")))
                .setImageRequest(ImageRequest.fromUri(Uri.parse("http://www.expresscopy.com/blog/wp-content/uploads/2012/08/Sunflower_large.jpg")))
                .setOldController(image3.getController())
                .build();
        image3.setController(controllerImg3);



        SimpleDraweeView image4 = (SimpleDraweeView)findViewById(R.id.iv_four);


        int width = 50, height = 50;
        ImageRequest request4 = ImageRequestBuilder.newBuilderWithSource(Uri.parse("http://cdn2.larepublica.pe/sites/default/files/styles/img_620x369/public/imagen/2015/08/18/andr-Noticia-399494.jpg"))
                .setResizeOptions(new ResizeOptions(width, height))
                .build();
        PipelineDraweeController controller4 = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setOldController(image4.getController())
                .setImageRequest(request4)
                .build();
        image4.setController(controller4);

    }




}
