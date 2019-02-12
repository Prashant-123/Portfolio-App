package com.prashant.portfolio.AboutMe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prashant.portfolio.R;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.ArrayList;

class AwardsAdapter extends RecyclerView.Adapter<AwardsAdapter.ViewHolder> {

    public static ArrayList<AwardsDC> mData;
    private LayoutInflater mInflater;
    Context mContext;

    public AwardsAdapter(FragmentActivity context, ArrayList<AwardsDC> arr) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = arr;

    }

    @NonNull
    @Override
    public AwardsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.awards_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AwardsAdapter.ViewHolder holder, int position) {
//        holder.institute_name.setText(mData.get(holder.getAdapterPosition()).getInstitute_name());
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
//        TextView institute_name, course, position, yop, about;
//        RoundedImageView image;

        EasyFlipView mEasyFlipView;

        public ViewHolder(View itemView) {
            super(itemView);
//            institute_name = itemView.findViewById(R.id.inst_name);
//            position = itemView.findViewById(R.id.post);
//            yop = itemView.findViewById(R.id.yop);
//            course = itemView.findViewById(R.id.course);
//            about = itemView.findViewById(R.id.performance);
//            image = itemView.findViewById(R.id.high_ed_pic_model);
        }
    }
}