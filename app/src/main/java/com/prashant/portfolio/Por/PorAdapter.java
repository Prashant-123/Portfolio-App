package com.prashant.portfolio.Por;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.prashant.portfolio.R;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.ArrayList;

class PorAdapter extends RecyclerView.Adapter<PorAdapter.ViewHolder> {

    public static ArrayList<PorDC> mData;
    private LayoutInflater mInflater;
    Context mContext;

    public PorAdapter(FragmentActivity context, ArrayList<PorDC> arr) {
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
        for(int i = 0; i< mData.get(holder.getAdapterPosition()).roles.size(); i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(80,20,20,20);
            View textView = mInflater.inflate(R.layout.por_textview, null);
            textView.setLayoutParams(params);
            TextView tv = textView.findViewById(R.id.role);
            tv.setText(mData.get(holder.getAdapterPosition()).roles.get(i));
            holder.rolesLayout.addView(textView);
        }
//        holder.course.setText(mData.get(holder.getAdapterPosition()).getCourse());
//        holder.position.setText(mData.get(holder.getAdapterPosition()).getPost());
//        holder.yop.setText(mData.get(holder.getAdapterPosition()).getYop());
//        holder.about.setText(mData.get(holder.getAdapterPosition()).getPerformance());
//        Glide.with(holder.itemView).load(mData.get(holder.getAdapterPosition()).getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
//
        TextView heading;
        LinearLayout rolesLayout;
//        RoundedImageView image;

        EasyFlipView mEasyFlipView;

        public ViewHolder(View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.heading);
            rolesLayout = itemView.findViewById(R.id.roles);
//            position = itemView.findViewById(R.id.post);
//            yop = itemView.findViewById(R.id.yop);
//            course = itemView.findViewById(R.id.course);
//            about = itemView.findViewById(R.id.performance);
//            image = itemView.findViewById(R.id.high_ed_pic_model);
        }
    }
}