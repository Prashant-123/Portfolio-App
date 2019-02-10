package com.prashant.portfolio.Education;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prashant.portfolio.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HigherStudies extends Fragment {

    public static HigherStudiesDC newInstance() {
        return new HigherStudiesDC();
    }
    @BindView(R.id.rv)
    RecyclerView rv;

    HighEduAdapter adapter;
    ArrayList<HigherStudiesDC> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);
        ButterKnife.bind(this, view);

        HigherStudiesDC data = new HigherStudiesDC("SSCBS", "B.Sc(H) Computer Science", "Under-Graduation", "2016-2019", "Performance:  8.8 CGPA", "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
        list.add(data);
        list.add(data);
        list.add(data);
//        list.add(data);
//        list.add(data);
//        list.add(data);
//        list.add(data);

        rv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HighEduAdapter(getActivity(), list);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);

        return view;
    }

}