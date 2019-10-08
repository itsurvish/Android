package com.example.pritjoshi.prit_project1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class recyclerviewAdapter extends RecyclerView.Adapter<com.example.pritjoshi.prit_project1.recyclerviewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerView.ViewHolder";
    private List<com.example.pritjoshi.prit_project1.Product> mProductList;
    private Context mContext;


        public recyclerviewAdapter(Context context, List<com.example.pritjoshi.prit_project1.Product> products){
            this.mContext = context;
            this.mProductList = products;
        }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View item = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup ,false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.pritjoshi.prit_project1.recyclerviewAdapter.ViewHolder viewHolder, int i) {
            final com.example.pritjoshi.prit_project1.Product product = mProductList.get(i);
        viewHolder.titleTxtView.setText(product.getName());
        viewHolder.priceTxtView.setText(String.valueOf(product.getPrice()));
        Glide.with(mContext)
                .load(mContext.getResources().getIdentifier("drawable/" + product.getImg(), null, mContext.getPackageName()))
                        .into(viewHolder.imgView);

        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (((Activity) mContext).findViewById(R.id.displayFrame) == null) {
//                    Intent i = new Intent(mContext, ProductDisplayActivity.class);
//                    i.putExtra("name", product.getName());
//                    Log.d(TAG, "onClick: "+ product.getImg());
//                    i.putExtra("image", product.getImg());
//                    i.putExtra("price", product.getPrice());
//                    mContext.startActivity(i);
//                } else {
                    FragmentManager fragmentManager = ((com.example.pritjoshi.prit_project1.MainActivity) mContext).getSupportFragmentManager();
                    Fragment fragment = fragmentManager.findFragmentById(R.id.mainFrame);
                    fragment = com.example.pritjoshi.prit_project1.DisplayFragment.newInstance(product);
                    fragmentManager.beginTransaction().replace(R.id.mainFrame, fragment).commit();
                //}
            }
            });
        }



    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
          TextView titleTxtView, priceTxtView;
          RelativeLayout relativeLayout;
          ImageView imgView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxtView = itemView.findViewById(R.id.txt_name);
            priceTxtView = itemView.findViewById(R.id.qtyTxtView);
            imgView = itemView.findViewById(R.id.image);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);

        }


    }
}

