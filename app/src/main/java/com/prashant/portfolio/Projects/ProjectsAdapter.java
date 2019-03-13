package com.prashant.portfolio.Projects;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.prashant.portfolio.R;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.ArrayList;

class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolder> {

    public static ArrayList<ProjectsModel> mData;
    private LayoutInflater mInflater;
    Context mContext;
    private ItemClickListener mClickListener;

    public ProjectsAdapter(FragmentActivity context, ArrayList<ProjectsModel> arr) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = arr;

    }

    @NonNull
    @Override
    public ProjectsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.projects_model_root, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProjectsAdapter.ViewHolder holder, int position) {
        holder.name.setText(mData.get(holder.getAdapterPosition()).name);
        holder.duration.setText(mData.get(holder.getAdapterPosition()).duration);
        holder.description.setText(mData.get(holder.getAdapterPosition()).description);
        holder.ts.setText(mData.get(holder.getAdapterPosition()).tech_stack);

        Glide.with(holder.itemView).load(mData.get(holder.getAdapterPosition()).image).into(holder.image);
        Glide.with(holder.itemView).load(mData.get(holder.getAdapterPosition()).image).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        RoundedImageView icon;
        TextView name, duration, description, ts;
        EasyFlipView mEasyFlipView;

        public ViewHolder(View itemView) {
            super(itemView);
            mEasyFlipView = itemView.findViewById(R.id.flip_card);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.p_name);
            duration = itemView.findViewById(R.id.p_duration);
            description = itemView.findViewById(R.id.p_description);
            ts = itemView.findViewById(R.id.tech_stack);
            image = itemView.findViewById(R.id.pro_image);
            icon = itemView.findViewById(R.id.p_icon);
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