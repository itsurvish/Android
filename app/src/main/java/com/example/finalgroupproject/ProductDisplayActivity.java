package com.example.finalgroupproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;


public class ProductDisplayActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_display);
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.displayFrame);
        Intent i=getIntent();
        Product product = new Product();
        product.setName(i.getStringExtra("name"));
        product.setPrice(i.getFloatExtra("price",0));
        product.setImg(i.getStringExtra("Image"));


        if (frag == null){

            frag = DisplayFragment.newInstance(product);

            fm.beginTransaction().replace(R.id.displayFrame, frag).commit();
        }
    }
    }
