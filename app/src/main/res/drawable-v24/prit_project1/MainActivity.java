package com.example.pritjoshi.prit_project1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.mainFrame);
        if (fragment == null) {
            fragment = new com.example.pritjoshi.prit_project1.ProductFragment();
            fragmentManager.beginTransaction().add(R.id.mainFrame, fragment).commit();
        }


    }
}
