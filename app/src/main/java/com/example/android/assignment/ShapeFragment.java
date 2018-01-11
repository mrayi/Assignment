package com.example.android.assignment;

import android.app.DialogFragment;
import android.content.Intent;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.android.assignment.Controller.GridViewAdapter;

/**
 * Created by Jack on 2018-01-10.
 */

public class ShapeFragment extends Fragment {

    GridView gv;
    Button btn;
    String[] shapeName = {"Circle", "Triangle", "Square", "Rectangle", "Pentagon", "Hexagon"};
    String[] desc = {"Yellow Color", "Orange Color", "Blue Color", "Green Color", "Red Color", "Purple Color"};
    int[] images = {R.drawable.circle, R.drawable.triangle, R.drawable.square, R.drawable.rectangle, R.drawable.pentagon, R.drawable.hexagon};
    private Toast toast;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shape, container, false);
        gv = (GridView) rootView.findViewById(R.id.gvShape);

        GridViewAdapter adapter = new GridViewAdapter(getActivity(), shapeName, desc, images);
        gv.setAdapter(adapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(toast != null){
                    toast.cancel();
                }
                toast = Toast.makeText(getActivity(), shapeName[position], Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        btn = (Button) rootView.findViewById(R.id.ButtonWatch);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VideoActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
