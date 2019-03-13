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

public class HigherStudies extends Fragment {

    public static HigherStudiesModel newInstance() {
        return new HigherStudiesModel();
    }
    @BindView(R.id.rv)
    RecyclerView rv;

    HighEduAdapter adapter;
    public static List<HigherStudiesModel> hst_list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);
        ButterKnife.bind(this, view);

        hst_list.clear();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();
        API profile = retrofit.create(API.class);
        final Call<List<HigherStudiesModel>> hst = profile.hst();
        hst.enqueue(new Callback<List<HigherStudiesModel>>() {
            @Override
            public void onResponse(Call<List<HigherStudiesModel>> call, Response<List<HigherStudiesModel>> response) {
                hst_list.addAll(response.body());
                rv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
                rv.setHasFixedSize(true);
                rv.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter = new HighEduAdapter(getActivity(), hst_list);
                rv.setItemAnimator(new DefaultItemAnimator());
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<HigherStudiesModel>> call, Throwable t) {

            }
        });

        return view;
    }

}