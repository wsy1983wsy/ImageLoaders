package com.wsy.imageloaders;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.wsy.imageloaders.adapter.ListAdapter;

/**
 * Created by songyewang on 16/9/20.
 */
public class PicassoGridView extends AppCompatActivity {
    public GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_grid_view);
        gridView = (GridView) findViewById(R.id.gridView);
        ListAdapter listAdapter = new ListAdapter(this, R.layout.image_list_item, Urls.eatImages, ListAdapter.LOADER_TYPE_PICASSO);
        gridView.setAdapter(listAdapter);
    }

}
