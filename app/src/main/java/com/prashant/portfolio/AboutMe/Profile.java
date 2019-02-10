package com.prashant.portfolio.AboutMe;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.prashant.portfolio.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.prashant.portfolio.MainActivity.aboutmeDC;

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
        ButterKnife.bind(this, myView);

        Glide.with(getContext()).load(aboutmeDC.getProfile_pic()).into(dp);
        name.setText(aboutmeDC.getName());
        position.setText(aboutmeDC.getPost());
        level.setText("Level: " + aboutmeDC.getLevel());
        projects.setText(aboutmeDC.getNew_projects());
        skills.setText(aboutmeDC.getNew_skills());

        return myView;
    }
}
