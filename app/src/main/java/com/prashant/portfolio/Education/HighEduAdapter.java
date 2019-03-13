package com.prashant.portfolio.Education;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.prashant.portfolio.R;
import java.util.List;

class HighEduAdapter extends RecyclerView.Adapter<HighEduAdapter.ViewHolder> {

    public static List<HigherStudiesModel> mData;
    private LayoutInflater mInflater;
    Context mContext;

    public HighEduAdapter(FragmentActivity context, List<HigherStudiesModel> arr) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = arr;

    }

    @NonNull
    @Override
    public HighEduAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.higher_edu_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HighEduAdapter.ViewHolder holder, int position) {
        holder.institute_name.setText(mData.get(holder.getAdapterPosition()).getInstitute_name());
        holder.course.setText(mData.get(holder.getAdapterPosition()).getCourse());
        holder.position.setText(mData.get(holder.getAdapterPosition()).getPost());
        holder.yop.setText(mData.get(holder.getAdapterPosition()).getYop());
        holder.about.setText(mData.get(holder.getAdapterPosition()).getPerformance());
        Glide.with(holder.itemView).load(mData.get(holder.getAdapterPosition()).getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView institute_name, course, position, yop, about;
        RoundedImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            institute_name = itemView.findViewById(R.id.inst_name);
            position = itemView.findViewById(R.id.post);
            yop = itemView.findViewById(R.id.yop);
            course = itemView.findViewById(R.id.course);
            about = itemView.findViewById(R.id.performance);
            image = itemView.findViewById(R.id.high_ed_pic_model);
        }
    }
}