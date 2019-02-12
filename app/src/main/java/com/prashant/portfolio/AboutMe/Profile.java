package com.prashant.portfolio.AboutMe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.github.javiersantos.materialstyleddialogs.enums.Duration;
import com.github.javiersantos.materialstyleddialogs.enums.Style;
import com.makeramen.roundedimageview.RoundedImageView;
import com.prashant.portfolio.DownloadTask;
import com.prashant.portfolio.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.prashant.portfolio.MainActivity.aboutmeDC;

public class Profile extends Fragment{
    public Profile() {}

    @BindView(R.id.display_name)
    TextView name;
    @BindView(R.id.position)
    TextView position;
    @BindView(R.id.level)
    TextView level;
    @BindView(R.id.skills)
    TextView skills;
    @BindView(R.id.no_of_projects)
    TextView projects;
    @BindView(R.id.display_image)
    RoundedImageView dp;
    @BindView(R.id.cv_card)
    MaterialButton cv;
    @BindView(R.id.projects_card)
    MaterialButton projects_card;
    @BindView(R.id.skills_card)
    MaterialButton skills_card;
    @BindView(R.id.activity_card)
    MaterialButton activity_card;

    String url = "https://firebasestorage.googleapis.com/v0/b/portfolio-af693.appspot.com/o/CV.pdf?alt=media&token=c9e7c658-0c81-40fe-ab5a-3452fd2eb427";

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View myView = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, myView);

        Glide.with(getContext()).load(aboutmeDC.getProfile_pic()).into(dp);
        name.setText(aboutmeDC.getName());
        position.setText(aboutmeDC.getPost());
        level.setText("Level: " + aboutmeDC.getLevel());
        projects.setText(aboutmeDC.getNew_projects());
        skills.setText(aboutmeDC.getNew_skills());

        DownloadTask task = new DownloadTask(getContext());
        task.execute(url);

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CV(inflater);
            }
        });

        projects_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Awards(inflater);
            }
        });

        skills_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SkillSet(inflater);
            }
        });

        activity_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activities(inflater);
            }
        });

        return myView;
    }

    public void CV(LayoutInflater inflater) {
        MaterialStyledDialog dialog = new MaterialStyledDialog.Builder(getContext())
                .setCustomView(inflater.inflate(R.layout.cv_card, null))
                .setStyle(Style.HEADER_WITH_ICON).setIcon(R.drawable.ic_cv)
                .setHeaderDrawable(R.drawable.me).withDarkerOverlay(true)
                .withIconAnimation(true)
                .withDialogAnimation(true, Duration.FAST)
                .setPositiveText(R.string.view_cv).onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        try {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setDataAndType(Uri.parse(url), "application/pdf");
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            getContext().startActivity(intent);
                        } catch (Exception e) {
                            Toast.makeText(getContext(), "PDF Viewer not installed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).setNegativeText(R.string.cancel).setCancelable(false)
                .build();
        dialog.show();
    }

    public void SkillSet(LayoutInflater inflater) {
        MaterialStyledDialog dialog = new MaterialStyledDialog.Builder(getContext())
                .setCustomView(inflater.inflate(R.layout.skill_set, null))
                .setStyle(Style.HEADER_WITH_ICON).setIcon(R.drawable.ic_skills_home)
                .setHeaderDrawable(R.drawable.me).withDarkerOverlay(true)
                .withIconAnimation(true)
                .withDialogAnimation(true, Duration.FAST)
                .setPositiveText(R.string.view_cv).onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setDataAndType(Uri.parse(url), "application/pdf");
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getContext().startActivity(intent);
                    }
                }).setNegativeText(R.string.cancel).setCancelable(false)
                .build();
        dialog.show();
    }

    public void Awards(LayoutInflater inflater) {

        ArrayList<AwardsDC> awards = new ArrayList<>();

        View view = inflater.inflate(R.layout.recycler_view, null);
        MaterialStyledDialog dialog = new MaterialStyledDialog.Builder(getContext())
                .setCustomView(view)
                .setStyle(Style.HEADER_WITH_ICON).setIcon(R.drawable.ic_award)
                .setHeaderDrawable(R.drawable.me).withDarkerOverlay(true)
                .withIconAnimation(true)
                .withDialogAnimation(true, Duration.FAST)
                .setCancelable(true)
                .build();

        RecyclerView rv = view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        AwardsAdapter adapter = new AwardsAdapter(getActivity(), awards);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);

        awards.add(new AwardsDC());
        awards.add(new AwardsDC());
        adapter.notifyDataSetChanged();
        dialog.show();
    }

    public void Activities(LayoutInflater inflater) {
        MaterialStyledDialog dialog = new MaterialStyledDialog.Builder(getContext())
                .setCustomView(inflater.inflate(R.layout.interests, null))
                .setStyle(Style.HEADER_WITH_ICON).setIcon(R.drawable.ic_books)
                .setHeaderDrawable(R.drawable.me).withDarkerOverlay(true)
                .withIconAnimation(true)
                .withDialogAnimation(true, Duration.FAST)
                .setCancelable(true)
                .build();
        dialog.show();
    }
}
