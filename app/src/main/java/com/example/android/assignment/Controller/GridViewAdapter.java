package com.example.android.assignment.Controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;

import com.example.android.assignment.R;

/**
 * Created by Jack on 2018-01-10.
 */

public class GridViewAdapter extends BaseAdapter {

    private Context context;
    int[] images;

    public GridViewAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.gvmodel, null);
        }

        ImageView img = (ImageView) convertView.findViewById(R.id.imageview1);
        img .setImageResource(images[position]);

        return convertView;
    }
}
