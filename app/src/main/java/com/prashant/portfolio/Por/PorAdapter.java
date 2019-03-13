package com.prashant.portfolio.Por;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.prashant.portfolio.R;

import java.util.ArrayList;

class PorAdapter extends RecyclerView.Adapter<PorAdapter.ViewHolder> {

    public static ArrayList<PorModel> mData;
    private LayoutInflater mInflater;
    Context mContext;

    public PorAdapter(FragmentActivity context, ArrayList<PorModel> arr) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = arr;

    }

    @NonNull
    @Override
    public PorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.responsibility_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PorAdapter.ViewHolder holder, int position) {
        holder.heading.setText(mData.get(holder.getAdapterPosition()).getHeading());
        Glide.with(holder.itemView).load(mData.get(holder.getAdapterPosition()).image).into(holder.image);

        for(int i=0; i<mData.get(holder.getAdapterPosition()).roles.size(); i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(80,20,20,20);
            View textView = mInflater.inflate(R.layout.textview, null);
            textView.setLayoutParams(params);
            TextView tv = textView.findViewById(R.id.role);
            tv.setText(mData.get(holder.getAdapterPosition()).roles.get(i));
            holder.rolesLayout.addView(textView);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView heading;
        ImageView image;
        LinearLayout rolesLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.heading);
            image = itemView.findViewById(R.id.work_ex_image);
            rolesLayout = itemView.findViewById(R.id.roles);
        }
    }
}