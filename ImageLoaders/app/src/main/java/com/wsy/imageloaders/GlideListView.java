package com.wsy.imageloaders;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.ListPreloader;
import com.wsy.imageloaders.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songyewang on 16/9/19.
 */
public class GlideListView extends AppCompatActivity {
    public ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_listview);
        listview = (ListView) findViewById(R.id.listview);
        listview.setOnScrollListener(listPreloader);
        ListAdapter listAdapter = new ListAdapter(this, R.layout.image_list_item, Urls.ImageURls);
        listview.setAdapter(listAdapter);
    }

    private ListPreloader listPreloader = new ListPreloader<String>(new ListPreloader.PreloadModelProvider<String>() {
        @Override
        public List<String> getPreloadItems(int position) {
            List<String> preloads = new ArrayList<>(1);
            preloads.add(Urls.ImageURls.get(position));
            return preloads;
        }

        @Override
        public GenericRequestBuilder getPreloadRequestBuilder(String item) {
            return Glide.with(GlideListView.this).load(item);
        }
    }, new ListPreloader.PreloadSizeProvider<String>() {
        @Override
        public int[] getPreloadSize(String item, int adapterPosition, int perItemPosition) {
            int[] size = {200, 200};
            return size;
        }
    }, 3);
}
