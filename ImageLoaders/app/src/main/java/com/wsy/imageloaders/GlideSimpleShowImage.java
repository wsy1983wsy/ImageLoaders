package com.wsy.imageloaders;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

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

    public void onResourceImageClicked(View view) {
        ImageView targetImageView = (ImageView) findViewById(R.id.imageView);
        Glide.with(this).load(R.mipmap.stone).into(targetImageView);
    }

    public void onUriImageClicked(View view) {
        ImageView targetImageView = (ImageView) findViewById(R.id.imageView);
        Uri uri = resourceIdToUri(this, R.mipmap.stone);
        Glide.with(this).load(uri).into(targetImageView);
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
        Glide.with(this).load(imageFile).into(targetImageView);
    }

    public void onFadeInImageClicked(View view) {
        ImageView targetImageView = (ImageView) findViewById(R.id.imageView);
        String imageUrl = Urls.ImageURls.get(0);
        Glide.with(this).load(imageUrl).placeholder(R.mipmap.no_media).crossFade(1000).into(targetImageView);
    }

    public void onDontAnimateClicked(View view) {
        ImageView targetImageView = (ImageView) findViewById(R.id.imageView);
        String imageUrl = Urls.ImageURls.get(0);
        Glide.with(this).load(imageUrl).placeholder(R.mipmap.no_media).dontAnimate().into(targetImageView);
    }

    public void onResizeClicked(View view) {
        ImageView targetImageView = (ImageView) findViewById(R.id.imageView);
        String imageUrl = Urls.ImageURls.get(0);
        Glide.with(this).load(imageUrl).fitCenter().into(targetImageView);
    }
}
