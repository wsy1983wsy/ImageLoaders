package com.wsy.imageloaders;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by songyewang on 16/9/20.
 */
public class PicassoSimpleShowImage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_image);
        findViewById(R.id.animateButton).setVisibility(View.GONE);
        findViewById(R.id.fadeInButton).setVisibility(View.GONE);
    }

    public void onSimpleImageClicked(View view) {
        ImageView targetImageView = (ImageView) findViewById(R.id.imageView);
        String imageUrl = Urls.ImageURls.get(0);
        Picasso.with(this).load(imageUrl).into(targetImageView);
    }


    public void onResourceImageClicked(View view) {
        ImageView targetImageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(this).load(R.mipmap.stone).into(targetImageView);
    }

    public void onUriImageClicked(View view) {
        ImageView targetImageView = (ImageView) findViewById(R.id.imageView);
        Uri uri = resourceIdToUri(this, R.mipmap.stone);
        Picasso.with(this).load(uri).into(targetImageView);
    }

    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    private static Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }

    public void onFileImageClicked(View view) {
        File externalStorage = Environment.getExternalStorageDirectory();
        String imagePath = externalStorage.getAbsolutePath() + FOREWARD_SLASH + "Pictures" + FOREWARD_SLASH + "Picture_11_Taste.jpg";
        File imageFile = new File(imagePath);
        ImageView targetImageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(this).load(imageFile).into(targetImageView);
    }

    public void onResizeClicked(View view) {
        ImageView targetImageView = (ImageView) findViewById(R.id.imageView);
        String imageUrl = Urls.ImageURls.get(0);
        Picasso.with(this).load(imageUrl).resize(100, 100).into(targetImageView);
    }
}
