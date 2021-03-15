
package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    boolean showPic=true;
    public static final int NUMBER=0;
    public static final int COLOR=1;

    public WordAdapter(Activity context, ArrayList<Word> arrayList,boolean showPic_){
        super(context,0,arrayList);
        showPic=showPic_;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View wordView=convertView;
        final Word word=getItem(position);

        if(wordView==null){
            //从XML代码生成java对象并显示
            try{
                wordView=LayoutInflater.from(getContext()).inflate(R.layout.words_layout,parent,false);
            }catch (InflateException e){
                Log.e("WordAdapter","InflateError.");
            }
        }


        wordView.findViewById(R.id.wordImg1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),word.getChinese()+","+word.getEnglish()+"picture.",Toast.LENGTH_SHORT).show();
            }
        });

        TextView engView=(TextView)wordView.findViewById(R.id.englishWord1);
        engView.setText(word.getEnglish());

        TextView chiView=(TextView)wordView.findViewById(R.id.chineseWord1);
        chiView.setText(word.getChinese());

        if(word.getType()==WordAdapter.NUMBER){
            wordView.findViewById(R.id.playBtn).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(NumberFragment.player!=null){
                        if(NumberFragment.player.isPlaying()){
                            NumberFragment.player.stop();
                        }
                        NumberFragment.player.release();
                        NumberFragment.player=null;
                    }
                    NumberFragment.player=MediaPlayer.create(getContext(),word.getAuResource());
                    NumberFragment.player.start();
                    NumberFragment.player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if(NumberFragment.player!=null){
                                NumberFragment.player.release();
                                Toast.makeText(getContext(),"play released. (debug)",Toast.LENGTH_SHORT).show();
                            }
                            NumberFragment.player=null;
                        }
                    });
                }
            });
        }else {
            wordView.findViewById(R.id.playBtn).setVisibility(View.GONE);
        }

        if(showPic){
            ((ImageView)wordView.findViewById(R.id.wordImg1)).setImageResource(word.getImgResource());
        }else {
            wordView.findViewById(R.id.wordImg1).setVisibility(View.GONE);
        }

        switch (word.getType()){
            case 1:
                wordView.findViewById(R.id.wordImg1).setBackgroundColor(wordView.getResources().getColor(R.color.color_img_bg));
                ((TextView) wordView.findViewById(R.id.chineseWord1)).setTextColor(wordView.getResources().getColor(R.color.color_words_other));
                ((TextView) wordView.findViewById(R.id.englishWord1)).setTextColor(wordView.getResources().getColor(R.color.color_words_primary));
                wordView.findViewById(R.id.wordBg1).setBackgroundColor(wordView.getResources().getColor(R.color.color_words_bg));
                break;
            default:
                break;
        }

        return wordView;
    }
}

