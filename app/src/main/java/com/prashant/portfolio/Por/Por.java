package com.prashant.portfolio.Por;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prashant.portfolio.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Por extends Fragment {
    private static ArrayList<PorDC> por = new ArrayList<>();

    public Por() { }

    @BindView(R.id.rv)
    RecyclerView rv;

    PorAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View myView = inflater.inflate(R.layout.recycler_view, container, false);
        ButterKnife.bind(this, myView);

        ArrayList<String> roles = new ArrayList<>();
        roles.add("Hello");
        roles.add("Whassup?");
        por.add(new PorDC("hackCBS", "", roles));

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PorAdapter(getActivity(), por);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);

        return myView;
    }
}
