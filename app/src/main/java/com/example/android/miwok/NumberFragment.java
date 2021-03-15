/*
 * Copyright (c) 2020. JM Jiang or LintonC of berrySDU.com.
 */

package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumberFragment extends Fragment {


    ArrayList<Word> words=new ArrayList<>();
    static MediaPlayer player;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NumberFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NumberFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NumberFragment newInstance() {
        NumberFragment fragment = new NumberFragment();
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

        return inflater.inflate(R.layout.fragment_number, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        initialize();
    }

    private void initialize(){

        final View act=getView().findViewById(R.id.numbersRoot);
        Button backBtn=(Button) act.findViewById(R.id.backBtn_Num);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(act.getContext(),"debugBack",Toast.LENGTH_SHORT).show();
            }
        });

        initListView(act);
    }

    private void initListView(View act){
        for(int i=0;i<=100;i++){
            Word word_=new Word("English"+i,"中文"+i,R.drawable.family_daughter,WordAdapter.NUMBER);
            words.add(word_);
            words.get(i).setAuResource(R.raw.family_mother);
        }

        words.get(0).setImgResource(R.drawable.family_daughter);
        words.get(1).setImgResource(R.drawable.family_father);
        words.get(2).setImgResource(R.drawable.family_grandfather);
        words.get(3).setImgResource(R.drawable.family_grandmother);
        words.get(4).setImgResource(R.drawable.family_grandmother);
        words.get(5).setImgResource(R.drawable.family_mother);
        words.get(6).setImgResource(R.drawable.family_younger_brother);
        words.get(7).setImgResource(R.drawable.family_younger_sister);

        words.get(0).setAuResource(R.raw.family_daughter);
        words.get(1).setAuResource(R.raw.family_father);
        words.get(2).setAuResource(R.raw.family_grandfather);
        words.get(3).setAuResource(R.raw.family_grandmother);
        words.get(4).setAuResource(R.raw.family_mother);
        words.get(5).setAuResource(R.raw.family_older_brother);
        words.get(6).setAuResource(R.raw.family_older_sister);

        ListView view=(ListView)act.findViewById(R.id.listViewNum);

        view.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Log.v("word"+i+" ",words.get(i).toString());
                Toast.makeText(getContext(),words.get(i).getChinese()+","+words.get(i).getEnglish()+"picture.OutDebug.",Toast.LENGTH_SHORT).show();
            }
        });

        view.setAdapter(new WordAdapter(getActivity(),words,true));
        player= MediaPlayer.create(getContext(),R.raw.family_daughter);
    }
}