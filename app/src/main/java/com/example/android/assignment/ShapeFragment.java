package com.example.android.assignment;

import android.content.Intent;
import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android.assignment.Controller.GridViewAdapter;

/**
 * Created by Jack on 2018-01-10.
 */

public class ShapeFragment extends Fragment {

    GridView gv;
    String[] shapeName = {"Circle", "Triangle", "Square", "Rectangle", "Pentagon", "Hexagon"};
    int[] images = {R.drawable.circle, R.drawable.triangle, R.drawable.square, R.drawable.rectangle, R.drawable.pentagon, R.drawable.hexagon};
    int[] sounds = {R.raw.pronunciation_en_circle, R.raw.pronunciation_en_triangle, R.raw.pronunciation_en_square, R.raw.pronunciation_en_rectangle, R.raw.pronunciation_en_pentagon, R.raw.pronunciation_en_hexagon};

    private Toast toast;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shape, container, false);
        gv = (GridView) rootView.findViewById(R.id.gvShape);

        GridViewAdapter adapter = new GridViewAdapter(getActivity(), images);
        gv.setAdapter(adapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final MediaPlayer sound = MediaPlayer.create(getActivity(), sounds[position]);
                sound.start();

                if(toast != null){
                    toast.cancel();
                }
                toast = Toast.makeText(getActivity(), shapeName[position], Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        return rootView;
    }

}
