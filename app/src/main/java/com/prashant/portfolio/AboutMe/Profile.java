package com.prashant.portfolio.AboutMe;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.design.chip.Chip;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.github.javiersantos.materialstyleddialogs.enums.Duration;
import com.github.javiersantos.materialstyleddialogs.enums.Style;
import com.google.gson.GsonBuilder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.prashant.portfolio.R;
import com.prashant.portfolio.Utils.API;
import com.prashant.portfolio.Utils.ApiClient;
import com.prashant.portfolio.Utils.DownloadTask;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.prashant.portfolio.MainActivity.TAG;
import static com.prashant.portfolio.MainActivity.aboutmeModel;

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
    @BindView(R.id.follow)
    MaterialButton follow;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View myView = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, myView);

        Glide.with(getContext()).load(aboutmeModel.profile_pic).into(dp);
        name.setText(aboutmeModel.name);
        position.setText(aboutmeModel.post);
        level.setText("Level: " + aboutmeModel.level);
        projects.setText(aboutmeModel.new_projects);
        skills.setText(aboutmeModel.new_skills);

        DownloadTask task = new DownloadTask(getContext());
        task.execute(aboutmeModel.cv_pdf);

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CV();
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
                Interests(inflater);
            }
        });
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FollowMe(inflater);
            }
        });

        return myView;
    }

    public void FollowMe(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.follow, null);
        AlertDialog alertDialog = new AlertDialog.Builder(
                getActivity()).create();
        alertDialog.setView(view);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        alertDialog.show();

        final MaterialButton linkedin, git, play, fb, insta;
        linkedin = alertDialog.findViewById(R.id.b_linkedin);
        git = alertDialog.findViewById(R.id.b_github);
        play = alertDialog.findViewById(R.id.b_play);
        fb = alertDialog.findViewById(R.id.b_fb);
        insta = alertDialog.findViewById(R.id.b_insta);

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ln_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/pk021998/"));
                startActivity(ln_intent);
            }
        });

        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent git_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Prashant-123/"));
                startActivity(git_intent);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent play_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Prashant%27s+Android"));
                startActivity(play_intent);
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent fb_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100006470866071"));
                    startActivity(fb_intent);
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/pk021998")));
                }
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/_u/p_r_a_s_h_a_n_t._");
                Intent insta_intent = new Intent(Intent.ACTION_VIEW, uri);
                insta_intent.setPackage("com.instagram.android");
                try {
                    startActivity(insta_intent);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/p_r_a_s_h_a_n_t._")));
                }
            }
        });
    }

    public void CV() {
                        try {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setDataAndType(Uri.parse(aboutmeModel.cv_pdf), "application/pdf");
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            getContext().startActivity(intent);
                        } catch (Exception e) {
                            Toast.makeText(getContext(), "PDF Viewer not installed", Toast.LENGTH_SHORT).show();
                        }
    }

    public void SkillSet(LayoutInflater inflater) {

        final List<SkillSetModel> skills = new ArrayList<>();
        final View view = inflater.inflate(R.layout.skill_set, null);
        final ScrollView rootView = view.findViewById(R.id.skillset_root);
        MaterialStyledDialog dialog = new MaterialStyledDialog.Builder(getContext())
                .setCustomView(view)
                .setStyle(Style.HEADER_WITH_ICON).setIcon(R.drawable.ic_skills_home)
                .setHeaderDrawable(R.drawable.tech_doodle).withDarkerOverlay(true)
                .withIconAnimation(true)
                .withDialogAnimation(true, Duration.FAST)
                .build();

//        API Request
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();
        API profile = retrofit.create(API.class);
        Call<List<SkillSetModel>> call = profile.Skills();
        call.enqueue(new Callback<List<SkillSetModel>>() {
            @Override
            public void onResponse(Call<List<SkillSetModel>> call, Response<List<SkillSetModel>> response) {
                skills.addAll(response.body());
                for(int i=0; i<skills.size(); i++) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(30,30,30,30);
                    Chip chip = new Chip(view.getContext());
                    chip.setLayoutParams(layoutParams);
                    chip.setText(skills.get(i).skill);
//                    chip.setChipIcon();
                    rootView.addView(chip);
                }
            }

            @Override
            public void onFailure(Call<List<SkillSetModel>> call, Throwable t) {
                Log.i(TAG, t.getMessage());
            }
        });

        dialog.show();
    }

    public void Awards(LayoutInflater inflater) {

        final List<AwardsModel> awards = new ArrayList<>();

        View view = inflater.inflate(R.layout.recycler_view, null);
        MaterialStyledDialog dialog = new MaterialStyledDialog.Builder(getContext())
                .setCustomView(view)
                .setStyle(Style.HEADER_WITH_ICON).setIcon(R.drawable.ic_award)
                .setHeaderDrawable(R.drawable.awards).withDarkerOverlay(true).setHeaderScaleType(ImageView.ScaleType.FIT_XY)
                .withIconAnimation(true)
                .withDialogAnimation(true, Duration.FAST)
                .setCancelable(true)
                .build();

        RecyclerView rv = view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        final AwardsAdapter adapter = new AwardsAdapter(getActivity(), awards, dialog);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        dialog.show();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();
        API profile = retrofit.create(API.class);
        Call<List<AwardsModel>> call = profile.getAwards();
        call.enqueue(new Callback<List<AwardsModel>>() {
            @Override
            public void onResponse(Call<List<AwardsModel>> call, Response<List<AwardsModel>> response) {
                awards.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<AwardsModel>> call, Throwable t) {
                Log.i(TAG, t.getMessage());
            }
        });
    }

    public void Interests(LayoutInflater inflater) {

        final View view = inflater.inflate(R.layout.interests, null);
        MaterialStyledDialog dialog = new MaterialStyledDialog.Builder(getContext())
                .setCustomView(view)
                .setStyle(Style.HEADER_WITH_ICON).setIcon(R.drawable.ic_books).setHeaderScaleType(ImageView.ScaleType.FIT_XY)
                .setHeaderDrawable(R.drawable.interests).withDarkerOverlay(true)
                .withIconAnimation(true)
                .withDialogAnimation(true, Duration.FAST)
                .setCancelable(true)
                .build();

                setInterests(view, aboutmeModel.interests.split(","));
        dialog.show();
    }

    private void setInterests(View view, String[] ints) {
        Chip int1, int2, int3, int4, int5;
        int1 = view.findViewById(R.id.int1);
        int2 = view.findViewById(R.id.int2);
        int3 = view.findViewById(R.id.int3);
        int4 = view.findViewById(R.id.int4);
        int5 = view.findViewById(R.id.int5);

        int1.setText(ints[0]);
        int2.setText(ints[1]);
        int3.setText(ints[2]);
        int4.setText(ints[3]);
        int5.setText(ints[4]);
    }
}
