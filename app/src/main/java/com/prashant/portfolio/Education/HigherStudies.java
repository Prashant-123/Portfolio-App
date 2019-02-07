package com.prashant.portfolio.Education;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prashant.portfolio.R;

public class HigherStudies extends Fragment {

    public static HigherStudies newInstance() {
        return new HigherStudies();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.higher_studies, container, false);
        return view;
    }

}