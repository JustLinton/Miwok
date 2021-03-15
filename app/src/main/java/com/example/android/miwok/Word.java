package com.example.android.miwok;

public class Word {

    public Word(String english_,String chinese_,int imgResource_,int type_){
        english=english_;chinese=chinese_;imgResource=imgResource_;type=type_;
    }
    public String getEnglish(){return english;}
    public String getChinese(){return chinese;}
    public int getImgResource(){return imgResource;}
    public int getType(){return type;}
    public int getAuResource(){return auResource;}

    public void setImgResource(int imgResource_){imgResource=imgResource_;}
    public void setAuResource(int auResource_){auResource=auResource_;}

    private String english;
    private String chinese;
    private int imgResource;
    private int auResource;
    private int type;

}
