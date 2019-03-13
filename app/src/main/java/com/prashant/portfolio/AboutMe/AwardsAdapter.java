package com.prashant.portfolio.AboutMe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.prashant.portfolio.R;

import java.util.List;

class AwardsAdapter extends RecyclerView.Adapter<AwardsAdapter.ViewHolder> {

    public static List<AwardsModel> mData;
    private LayoutInflater mInflater;
    Context mContext;
    MaterialStyledDialog dialog;

    public AwardsAdapter(FragmentActivity context, List<AwardsModel> arr, MaterialStyledDialog dialog) {
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = arr;
        this.dialog = dialog;

    }

    @NonNull
    @Override
    public AwardsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.awards_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AwardsAdapter.ViewHolder holder, int position) {
        holder.event_name.setText(mData.get(holder.getAdapterPosition()).getEvent_name());
        holder.sub_heading.setText(mData.get(holder.getAdapterPosition()).getSub_heading());
        holder.description.setText(mData.get(holder.getAdapterPosition()).getDescription());
        Glide.with(holder.itemView).load(mData.get(holder.getAdapterPosition()).getImage()).into(holder.image);

        final ImagePopup imagePopup = new ImagePopup(holder.itemView.getContext());
        imagePopup.setWindowHeight(800); // Optional
        imagePopup.setWindowWidth(800); // Optional
        imagePopup.setFullScreen(true); // Optional
        imagePopup.setHideCloseIcon(false);  // Optional
        imagePopup.setImageOnClickClose(true);  // Optional
        imagePopup.initiatePopupWithPicasso(mData.get(holder.getAdapterPosition()).certificate);

        holder.view_cert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePopup.viewPopup();
                dialog.dismiss();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView event_name, sub_heading, description;
        ImageView image;
        MaterialButton view_cert;

        public ViewHolder(View itemView) {
            super(itemView);
            event_name = itemView.findViewById(R.id.award_heading);
            sub_heading = itemView.findViewById(R.id.sub_heading);
            description = itemView.findViewById(R.id.descripiton);
            image = itemView.findViewById(R.id.award_image);
            view_cert = itemView.findViewById(R.id.view_cert);
        }
    }
}