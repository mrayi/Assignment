package com.example.android.assignment.Controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.assignment.R;

/**
 * Created by Jack on 2018-01-10.
 */

public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private String[] shapeName;
    private String[] desc;
    int[] images;

    public GridViewAdapter(Context context, String[] shapeName, String[] desc, int[] images) {
        this.context = context;
        this.shapeName = shapeName;
        this.desc = desc;
        this.images = images;
    }

    @Override
    public int getCount() {
        return shapeName.length;
    }

    @Override
    public Object getItem(int position) {
        return shapeName[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model, null);
        }
        TextView shapename = (TextView) convertView.findViewById(R.id.shapename);
        TextView shapeDesc = (TextView) convertView.findViewById(R.id.shapedesc);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageview1);

        shapename.setText(shapeName[position]);
        shapeDesc.setText(desc[position]);
        img .setImageResource(images[position]);

        return convertView;
    }
}
