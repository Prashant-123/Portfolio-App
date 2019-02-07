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

import com.prashant.portfolio.R;

import java.util.Set;

import static com.prashant.portfolio.MainActivity.TAG;

public class Education extends Fragment {
    public Education() { }

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    TextView tab_School, tab_HigherStudies, tab_Courses;
    ImageView placeholder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View myView = inflater.inflate(R.layout.fragment_education, container, false);

        viewPager = myView.findViewById(R.id.edu_viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        placeholder = myView.findViewById(R.id.placeholder);

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
                    case 0:
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
}
