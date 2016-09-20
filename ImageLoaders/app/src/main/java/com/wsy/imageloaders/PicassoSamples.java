package com.wsy.imageloaders;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by songyewang on 16/9/20.
 */
public class PicassoSamples extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glide_samples);
        findViewById(R.id.glideCacheButton).setVisibility(View.GONE);
    }

    public void onShowAImageClicked(View view) {
        Intent intent = new Intent(this, PicassoSimpleShowImage.class);
        startActivity(intent);
    }

    public void onListViewClicked(View view) {
        Intent intent = new Intent(this, PicassoListView.class);
        startActivity(intent);
    }

    public void onGridViewClicked(View view) {
        Intent intent = new Intent(this, PicassoGridView.class);
        startActivity(intent);
    }

    public void onCacheClicked(View view) {
        Toast.makeText(this, "此功能不提供", Toast.LENGTH_LONG).show();
    }
}
