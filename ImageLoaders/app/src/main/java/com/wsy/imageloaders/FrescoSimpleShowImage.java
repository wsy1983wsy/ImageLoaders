package com.wsy.imageloaders;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by songyewang on 16/9/21.
 */
public class FrescoSimpleShowImage extends AppCompatActivity {
    public SimpleDraweeView targetImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fresco_simple_image);
        targetImageView = (SimpleDraweeView) findViewById(R.id.imageView);
    }

    public void onSimpleImageClicked(View view) {
        String imageUrl = Urls.ImageURls.get(3);
        Uri uri = Uri.parse(imageUrl);
        targetImageView.setImageURI(uri);
    }

    public void onDraweeHierarchyClicked(View view) {
        GenericDraweeHierarchy hierarchy = targetImageView.getHierarchy();
        hierarchy.setPlaceholderImage(R.mipmap.stone);
        RoundingParams params = hierarchy.getRoundingParams();
        if (params == null) {
            params = new RoundingParams();
        }
//        params.setRoundAsCircle(true);
        params.setCornersRadius(10);
        params.setBorder(Color.BLUE, 1);
        hierarchy.setRoundingParams(params);
        String imageUrl = Urls.ImageURls.get(3);
        targetImageView.setImageURI(imageUrl);
    }

}
