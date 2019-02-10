package com.prashant.portfolio.Education;

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

class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder> {

    public static ArrayList<CoursesDC> mData;
    private LayoutInflater mInflater;
    Context mContext;
    private ItemClickListener mClickListener;

    public CoursesAdapter(FragmentActivity context, ArrayList<CoursesDC> arr) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = arr;

    }

    @NonNull
    @Override
    public CoursesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.courses_model_root, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CoursesAdapter.ViewHolder holder, int position) {
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//
//        TextView institute_name, course, position, yop, about;
//        RoundedImageView image;

        EasyFlipView mEasyFlipView;

        public ViewHolder(View itemView) {
            super(itemView);
            mEasyFlipView = itemView.findViewById(R.id.flip_card);
            itemView.setOnClickListener(this);
//            institute_name = itemView.findViewById(R.id.inst_name);
//            position = itemView.findViewById(R.id.post);
//            yop = itemView.findViewById(R.id.yop);
//            course = itemView.findViewById(R.id.course);
//            about = itemView.findViewById(R.id.performance);
//            image = itemView.findViewById(R.id.high_ed_pic_model);
        }

        @Override
        public void onClick(View v) {
            mEasyFlipView.flipTheView();
            if (mClickListener != null) {
                mClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}