package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat_layout);

        getSupportFragmentManager().beginTransaction().replace(R.id.numbersRoot,new FamilyFragment()).commit();
    }
}