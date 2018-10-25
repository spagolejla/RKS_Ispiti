package com.example.lalalas.a2017_2_2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lalalas.a2017_2_2.fragments.Fragment1;
import com.example.lalalas.a2017_2_2.helper.Util;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Util.otvoriFragmentKaoReplace(this,R.id.fragmentPlace, Fragment1.newInstance());
    }

}

