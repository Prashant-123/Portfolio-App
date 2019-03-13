package com.prashant.portfolio.Education;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.gson.GsonBuilder;
import com.prashant.portfolio.R;
import com.prashant.portfolio.Utils.API;
import com.prashant.portfolio.Utils.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.prashant.portfolio.MainActivity.TAG;

public class Education extends Fragment {
    public Education() { }

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    TextView tab_School, tab_HigherStudies, tab_Courses;
    ImageView placeholder;

    String surl, curl, hurl;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View myView = inflater.inflate(R.layout.fragment_education, container, false);

        viewPager = myView.findViewById(R.id.edu_viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        placeholder = myView.findViewById(R.id.placeholder);

        SetTabImages();
        SetTabLayout(myView);

        return myView;
    }

    private void SetTabLayout(View view) {
        tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        tab_School = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.edu_tab_school,null);
        tab_HigherStudies = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.edu_tab_higherstudies,null);
        tab_Courses = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.edu_tab_courses,null);

        tabLayout.getTabAt(0).setCustomView(tab_School);
        tabLayout.getTabAt(1).setCustomView(tab_HigherStudies);
        tabLayout.getTabAt(2).setCustomView(tab_Courses);

        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i(TAG, "onTabSelected: " + tab.getPosition());
                switch (tab.getPosition()) {
                    case 0: Glide.with(Education.this).load(surl).transition(DrawableTransitionOptions.withCrossFade()).into(placeholder); break;
                    case 1: Glide.with(Education.this).load(hurl).transition(DrawableTransitionOptions.withCrossFade()).into(placeholder); break;
                    case 2: Glide.with(Education.this).load(curl).transition(DrawableTransitionOptions.withCrossFade()).into(placeholder); break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void SetTabImages() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();
        API profile = retrofit.create(API.class);
        Call<Placeholder> placeholderCall = profile.placeholder();

        placeholderCall.enqueue(new Callback<Placeholder>() {
            @Override
            public void onResponse(Call<Placeholder> call, Response<Placeholder> response) {
                Glide.with(Education.this).load(response.body().school).transition(DrawableTransitionOptions.withCrossFade()).into(placeholder);
                surl = response.body().school;
                curl = response.body().courses;
                hurl = response.body().hst;
            }
            @Override
            public void onFailure(Call<Placeholder> call, Throwable t) {
            }
        });
    }
}
