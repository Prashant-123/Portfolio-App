package com.prashant.portfolio.Education;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.prashant.portfolio.R;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.List;

import static com.prashant.portfolio.MainActivity.TAG;

class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder> {

    public static List<CoursesModel> mData;
    private LayoutInflater mInflater;
    Context mContext;
    private ItemClickListener mClickListener;

    public CoursesAdapter(FragmentActivity context, List<CoursesModel> arr) {
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
        holder.name.setText("kiyjuthbgdvf");
        Glide.with(holder.itemView).load(mData.get(holder.getAdapterPosition()).image).into(holder.image);
        Glide.with(holder.itemView).load(mData.get(holder.getAdapterPosition()).image).into(holder.front);
        Glide.with(holder.itemView).load(mData.get(holder.getAdapterPosition()).image).into(holder.back);
        holder.instructor.setText(mData.get(holder.getAdapterPosition()).instructor);
        holder.institution.setText(mData.get(holder.getAdapterPosition()).institution);
        holder.name.setText(mData.get(holder.getAdapterPosition()).name);

        Log.i(TAG, "onBindViewHolder: " + holder.instructor.getText());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name, institution, instructor;
        RoundedImageView front, back;
        ImageView image;

        EasyFlipView mEasyFlipView;

        public ViewHolder(View itemView) {
            super(itemView);
            mEasyFlipView = itemView.findViewById(R.id.flip_card);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.c_name);
            institution = itemView.findViewById(R.id.c_institution);
            instructor = itemView.findViewById(R.id.c_instructor);
            front = itemView.findViewById(R.id.c_icon);
            back = itemView.findViewById(R.id.imageViewBack);
            image = itemView.findViewById(R.id.c_front);
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