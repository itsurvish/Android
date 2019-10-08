package com.example.finalgroupproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ProductFragment extends Fragment {
    private RecyclerView recyclerview;
    private recyclerviewAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v  = inflater.inflate(R.layout.fragment_product, container, false);
        recyclerview = (RecyclerView) v.findViewById(R.id.recyclerview);
        setAdapter();
        return v;
    }

    public void setAdapter(){
        ProductSingleton sSingleton = ProductSingleton.getProductSingleton();
        ArrayList<Product> products = sSingleton.getmProductList();
        mAdapter = new recyclerviewAdapter(getContext(), products);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(mLayoutManager);
        recyclerview.setAdapter(mAdapter);

    }
}
