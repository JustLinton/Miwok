/*
 * Copyright (c) 2020. JM Jiang or LintonC of berrySDU.com.
 */

package com.example.android.miwok;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ColorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ColorFragment extends Fragment {

    private ArrayList<Word> words=new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ColorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ColorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ColorFragment newInstance() {
        ColorFragment fragment = new ColorFragment();
        Bundle args = new Bundle();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        initialize();
    }

    private void initialize(){
        for(int i=0;i<=5000;i++){
            Word word_=new Word("English(Color)"+i,"中文（颜色）"+i,R.drawable.family_daughter,WordAdapter.COLOR);
            words.add(word_);
        }
        ListView listView=(ListView) getView().findViewById(R.id.colorParent);
        listView.setAdapter(new WordAdapter(getActivity(),words,false));
    }
}