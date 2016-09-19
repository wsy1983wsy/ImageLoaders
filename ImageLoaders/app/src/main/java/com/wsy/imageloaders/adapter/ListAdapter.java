package com.wsy.imageloaders.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wsy.imageloaders.R;

import java.util.List;

/**
 * Created by songyewang on 16/9/19.
 */
public class ListAdapter extends ArrayAdapter<String> {
    public List<String> imageUrls;
    public LayoutInflater layoutInflater;

    public static class ViewHolder {
        public ImageView imageView;
        public String url;
    }

    public ListAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.imageUrls = objects;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public String getItem(int position) {
        return imageUrls.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.image_list_item, parent, false);
        }
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
        String url = imageUrls.get(position);
        Glide.with(getContext()).load(url).placeholder(R.mipmap.no_media).into(viewHolder.imageView);
        view.setTag(viewHolder);
        return view;
    }
}
