package com.wsy.imageloaders;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by songyewang on 16/9/19.
 */
public class GlideCache extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glide_cache);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void onDiskCategoryClicked(View view) {
        Glide.with(this)
                .load(Urls.eatImages.get(0))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);
    }

    public void onSkipMemoryClicked(View view) {
        Glide.with(this)
                .load(Urls.eatImages.get(0))
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);
    }

    public void onThumbImageClicked(View view) {
        Glide.with(this)
                .load(Urls.eatImages.get(1))
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .thumbnail(0.1f)
                .into(imageView);
    }

    public void onOtherThumbImageClicked(View view) {
        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with(this)
                .load(Urls.eatImages.get(2));
        Glide.with(this)
                .load(Urls.eatImages.get(1))
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .thumbnail(thumbnailRequest)
                .into(imageView);
    }

    private SimpleTarget bytesTarget = new SimpleTarget<byte[]>() {
        @Override
        public void onResourceReady(byte[] bytes, GlideAnimation glideAnimation) {
            Log.d("GlideCache", "" + bytes.length);
        }
    };

    private SimpleTarget target = new SimpleTarget<Bitmap>(200, 200) {
        @Override
        public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
            imageView.setImageBitmap(bitmap);
        }
    };


    public void onSimpleTargetClicked(View view) {
        Glide.with(this) // could be an issue!
                .load(Urls.eatImages.get(2))
                .asBitmap()
                .into(target);
    }

    private RequestListener<String, GlideDrawable> requestListener = new RequestListener<String, GlideDrawable>() {
        @Override
        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
            // todo log exception

            // important to return false so the error placeholder can be placed
            return false;
        }

        @Override
        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
            return false;
        }
    };

    public void onListenerClicked(View view) {
        Glide.with(this)
                .load(Urls.eatImages.get(2))
                .listener(requestListener)
                .into(imageView);
    }

    public void onBlurTransformationClicked(View view) {
//        Glide.with(this)
//                .load(Urls.eatImages.get(2))
//                .transform(new BlurTransformation(this))
//                .into(imageView);

        Glide.with(this).load(Urls.eatImages.get(2))
                .bitmapTransform(
                        new jp.wasabeef.glide.transformations.BlurTransformation(this, 25),
                        new CropCircleTransformation(this))
                .into(imageView);
    }

    public void onGetImageBytesClicked(View view) {
        Glide.with(this) // could be an issue!
                .load(Urls.eatImages.get(2))
                .asBitmap()
                .toBytes()
                .into(bytesTarget);
    }
}
