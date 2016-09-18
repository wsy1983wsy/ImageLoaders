package com.wsy.imageloaders;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by songyewang on 16/9/18.
 */
public class GlideSimpleShowImage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_image);
    }

    public void onSimpleImageClicked(View view) {
        ImageView targetImageView = (ImageView) findViewById(R.id.imageView);
        String imageUrl = Urls.ImageURls.get(0);
        Glide.with(this).load(imageUrl).into(targetImageView);
    }
}
