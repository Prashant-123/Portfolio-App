package com.prashant.portfolio.Education;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

import static com.prashant.portfolio.MainActivity.TAG;

public class Courses extends Fragment {
    @BindView(R.id.rv)
    RecyclerView rv;

    CoursesAdapter adapter;
    public static List<CoursesModel> courses_list = new ArrayList<>();


    public static Courses newInstance() {
        return new Courses();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);
        ButterKnife.bind(this, view);

        courses_list.clear();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();
        API profile = retrofit.create(API.class);
        final Call<List<CoursesModel>> courses = profile.courses();
        courses.enqueue(new Callback<List<CoursesModel>>() {
            @Override
            public void onResponse(Call<List<CoursesModel>> call, Response<List<CoursesModel>> response) {
                courses_list.addAll(response.body());
                rv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
                rv.setHasFixedSize(true);
                rv.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter = new CoursesAdapter(getActivity(), courses_list);
                rv.setItemAnimator(new DefaultItemAnimator());
                rv.setAdapter(adapter);
                Log.i(TAG, "onResponse: " + response.body().get(0).instructor);
            }

            @Override
            public void onFailure(Call<List<CoursesModel>> call, Throwable t) {

            }
        });

        return view;
    }
}