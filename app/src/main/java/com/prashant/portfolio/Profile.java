package com.prashant.portfolio;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.prashant.portfolio.MainActivity.TAG;
import static com.prashant.portfolio.MainActivity.user;

public class Profile extends Fragment {
    public Profile() {}

    @BindView(R.id.display_name)
    TextView name;
    @BindView(R.id.position)
    TextView position;
    @BindView(R.id.level)
    TextView level;
    @BindView(R.id.skills)
    TextView skills;
    @BindView(R.id.projects)
    TextView projects;
    @BindView(R.id.display_image)
    RoundedImageView dp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View myView = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(myView);

//        Glide.with(getContext()).load(user.profile_pic).into(dp);
//        name.setText(user.name);
//        position.setText(user.name);
//        level.setText(user.name);
//        projects.setText(user.name);
//        skills.setText(user.name);

        Log.i(TAG, "onCreateView: " + user);



        return myView;
    }
}
