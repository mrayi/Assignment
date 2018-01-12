package com.example.android.assignment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.assignment.Controller.GridViewAdapter;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GameFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    static final int AUGMENTED_REALITY_REQUEST = 1;
    private Field[] drawablesFields;
    private ArrayList<Field> drawables = new ArrayList<>();
    private ImageView imageView;
    private Button btnCir;
    private Button btnRect;
    private Button btnTri;
    private Button btnPent;
    private Button btnHex;
    private ImageButton ibAr;
    private TextView tvScore;
    private Field curShape;
    private static int round;
    private static int ar;
    private List<String> myData;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public GameFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GameFragment newInstance(String param1, String param2) {
        GameFragment fragment = new GameFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void Initialize() {
        drawablesFields = com.example.android.assignment.R.drawable.class.getFields();
        drawables = new ArrayList<>();
        round = 0;
        ar = 1;

        // Get all shape name from drawable.
        for (Field field : drawablesFields) {
            try {
                if(field.getName().substring(0,2).equals("s_")) {
                    drawables.add(field);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Collections.shuffle(drawables);

        // Set image view.
        curShape = drawables.remove(0);
        try {
            imageView.setImageDrawable(getResources().getDrawable(curShape.getInt(null)));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game, container, false);

        // Initialize
        imageView = (ImageView) rootView.findViewById(R.id.ivShape);
        btnCir = (Button) rootView.findViewById(R.id.btnCir);
        btnRect = (Button) rootView.findViewById(R.id.btnRect);
        btnTri = (Button) rootView.findViewById(R.id.btnTri);
        btnPent = (Button) rootView.findViewById(R.id.btnPent);
        btnHex = (Button) rootView.findViewById(R.id.btnHex);
        tvScore = (TextView) rootView.findViewById(R.id.tvScore);
        ibAr = (ImageButton) rootView.findViewById(R.id.ibAr);

        Initialize();

        final int[] score = {Integer.parseInt(tvScore.getText().toString())};
        final int[] ans = {Integer.parseInt(String.valueOf(curShape.getName().charAt(2)))};

        btnCir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ans[0] == 0) {
                    score[0]++;
                }
                curShape = drawables.remove(0);
                ans[0] = Integer.parseInt(String.valueOf(curShape.getName().charAt(2)));
                tvScore.setText(String.valueOf(score[0]));
                try {
                    imageView.setImageDrawable(getResources().getDrawable(curShape.getInt(null)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                round++;
                if(round == 10) {
                    Intent intent = new Intent(getActivity(), ResultActivity.class);
                    intent.putExtra("score", String.valueOf(score[0]));
                    getActivity().startActivity(intent);
                    Initialize();
                    getActivity().getFragmentManager().popBackStack();
                }
            }
        });

        btnRect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ans[0] == 1) {
                    score[0]++;
                }
                curShape = drawables.remove(0);
                ans[0] = Integer.parseInt(String.valueOf(curShape.getName().charAt(2)));
                tvScore.setText(String.valueOf(score[0]));
                try {
                    imageView.setImageDrawable(getResources().getDrawable(curShape.getInt(null)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                round++;
                if(round == 10) {
                    Intent intent = new Intent(getActivity(), ResultActivity.class);
                    intent.putExtra("score", String.valueOf(score[0]));
                    getActivity().startActivity(intent);
                    Initialize();
                    getActivity().getFragmentManager().popBackStack();
                }
            }
        });

        btnTri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ans[0] == 2) {
                    score[0]++;
                }
                curShape = drawables.remove(0);
                ans[0] = Integer.parseInt(String.valueOf(curShape.getName().charAt(2)));
                tvScore.setText(String.valueOf(score[0]));
                try {
                    imageView.setImageDrawable(getResources().getDrawable(curShape.getInt(null)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                round++;
                if(round == 10) {
                    Intent intent = new Intent(getActivity(), ResultActivity.class);
                    intent.putExtra("score", String.valueOf(score[0]));
                    getActivity().startActivity(intent);
                    Initialize();
                    getActivity().getFragmentManager().popBackStack();
                }
            }
        });

        btnPent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ans[0] == 3) {
                    score[0]++;
                }
                curShape = drawables.remove(0);
                ans[0] = Integer.parseInt(String.valueOf(curShape.getName().charAt(2)));
                tvScore.setText(String.valueOf(score[0]));
                try {
                    imageView.setImageDrawable(getResources().getDrawable(curShape.getInt(null)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                round++;
                if(round == 10) {
                    Intent intent = new Intent(getActivity(), ResultActivity.class);
                    intent.putExtra("score", String.valueOf(score[0]));
                    getActivity().startActivity(intent);
                    Initialize();
                    getActivity().getFragmentManager().popBackStack();
                }
            }
        });

        btnHex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ans[0] == 4) {
                    score[0]++;
                }
                curShape = drawables.remove(0);
                ans[0] = Integer.parseInt(String.valueOf(curShape.getName().charAt(2)));
                tvScore.setText(String.valueOf(score[0]));
                try {
                    imageView.setImageDrawable(getResources().getDrawable(curShape.getInt(null)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                round++;
                if(round == 10) {
                    Intent intent = new Intent(getActivity(), ResultActivity.class);
                    intent.putExtra("score", String.valueOf(score[0]));
                    getActivity().startActivity(intent);
                    Initialize();
                    getActivity().getFragmentManager().popBackStack();
                }
            }
        });

        ibAr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ar == 1) {
                    ar = 0;
                    ibAr.setImageResource(R.drawable.artoolx);FragmentManager fragmentManager = getFragmentManager();
                    Intent intent = new Intent(getActivity(), ArActivity.class);
                    getActivity().startActivityForResult(intent, AUGMENTED_REALITY_REQUEST);
                }
            }
        });

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity a;

        if (context instanceof Activity){
            a=(Activity) context;
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("list", (Serializable) myData);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            //probably orientation change
            myData = (List<String>) savedInstanceState.getSerializable("list");
        }
    }
}
