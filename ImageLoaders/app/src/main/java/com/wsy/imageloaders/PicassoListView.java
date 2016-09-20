package com.wsy.imageloaders;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.wsy.imageloaders.adapter.ListAdapter;

/**
 * Created by songyewang on 16/9/20.
 */
public class PicassoListView extends AppCompatActivity {
    public ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_listview);
        listview = (ListView) findViewById(R.id.listview);
        ListAdapter listAdapter = new ListAdapter(this, R.layout.image_list_item, Urls.ImageURls, ListAdapter.LOADER_TYPE_PICASSO);
        listview.setAdapter(listAdapter);
    }

}
