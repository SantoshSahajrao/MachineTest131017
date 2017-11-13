package com.example.ravi.machinetest13_10_17;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ravi on 13/11/17.
 */

public class RecyAdpter extends RecyclerView.Adapter<RecyAdpter.DataviweHolder> {

    ArrayList mArrylist;
    Context mContxt;

    public RecyAdpter(ArrayList mArrylist, Context mContxt) {
        this.mArrylist = mArrylist;
        this.mContxt = mContxt;
    }

    @Override
    public DataviweHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_layout,null,false);

        return new DataviweHolder(view);
    }

    @Override
    public void onBindViewHolder(DataviweHolder holder, int position) {

        Data data = (Data) mArrylist.get(position);
        holder.mName.setText(data.getmName());
        holder.mAddress.setText(data.getmAddress());
        holder.mRatingBar.setRating(data.getmRating());
        Picasso.with(mContxt).load(data.getIcon()).into(holder.mImg);


    }

    @Override
    public int getItemCount() {
        return mArrylist.size();
    }

    class DataviweHolder extends RecyclerView.ViewHolder
    {
        ImageView mImg;
        TextView mName,mAddress;
        RatingBar mRatingBar;
        public DataviweHolder(View itemView) {
            super(itemView);

            mImg = itemView.findViewById(R.id.img);
            mName = itemView.findViewById(R.id.txtname);
            mAddress = itemView.findViewById(R.id.txtAddres);
            mRatingBar = itemView.findViewById(R.id.rating);
        }
    }
}
