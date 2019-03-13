package com.prashant.portfolio.Projects;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.GsonBuilder;
import com.prashant.portfolio.R;
import com.prashant.portfolio.Utils.API;
import com.prashant.portfolio.Utils.ApiClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Projects extends Fragment {


    public Projects() { }
    private static ArrayList<ProjectsModel> projects = new ArrayList<>();

    @BindView(R.id.rv)
    RecyclerView rv;

    ProjectsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View myView = inflater.inflate(R.layout.recycler_view, container, false);
        ButterKnife.bind(this, myView);

        projects.clear();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();
        final API profile = retrofit.create(API.class);
        Call<List<ProjectsModel>> call = profile.Projects();

        call.enqueue(new Callback<List<ProjectsModel>>() {
            @Override
            public void onResponse(Call<List<ProjectsModel>> call, Response<List<ProjectsModel>> response) {
                projects.addAll(response.body());
                rv.setHasFixedSize(true);
                rv.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter = new ProjectsAdapter(getActivity(), projects);
                rv.setItemAnimator(new DefaultItemAnimator());
                rv.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<ProjectsModel>> call, Throwable t) {
            }
        });

        return myView;
    }
}
