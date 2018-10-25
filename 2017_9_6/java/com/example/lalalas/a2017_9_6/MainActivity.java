package com.example.lalalas.a2017_9_6;



import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.lalalas.a2017_9_6.fragments.Fragment1;
import com.example.lalalas.a2017_9_6.helper.Util;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Util.otvoriFragmentKaoReplace(this,R.id.fragmentPlace, Fragment1.newInstance());


    }
}

