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

public class Courses extends Fragment {
    ArrayList<CoursesDC> list = new ArrayList<>();
    @BindView(R.id.rv)
    RecyclerView rv;

    CoursesAdapter adapter;

    public static Courses newInstance() {
        return new Courses();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);
        ButterKnife.bind(this, view);
        CoursesDC data = new CoursesDC();
        list.add(data);
        list.add(data);
        list.add(data);

        rv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CoursesAdapter(getActivity(), list);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);

        return view;
    }
}