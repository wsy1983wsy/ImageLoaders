package com.wsy.imageloaders;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by songyewang on 16/9/18.
 */
public class GlideSamples extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glide_samples);
    }

    public void onShowAImageClicked(View view) {
        Intent intent = new Intent(this, GlideSimpleShowImage.class);
        startActivity(intent);
    }

    public void onListViewClicked(View view) {
        Intent intent = new Intent(this, GlideListView.class);
        startActivity(intent);
    }
}
