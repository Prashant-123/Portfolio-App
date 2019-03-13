package com.prashant.portfolio.Por;

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
import com.prashant.portfolio.WorkEx.WorkexAdapter;
import com.prashant.portfolio.WorkEx.WorkexModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Por extends Fragment {

    public Por() { }
    private static ArrayList<WorkexModel> por = new ArrayList<>();

    @BindView(R.id.rv)
    RecyclerView rv;

    WorkexAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View myView = inflater.inflate(R.layout.recycler_view, container, false);
        ButterKnife.bind(this, myView);

        por.clear();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).build();
        API profile = retrofit.create(API.class);
        Call<List<WorkexModel>> call = profile.POR();

        call.enqueue(new Callback<List<WorkexModel>>() {
            @Override
            public void onResponse(Call<List<WorkexModel>> call, Response<List<WorkexModel>> response) {
                por.addAll(response.body());
                rv.setHasFixedSize(true);
                rv.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter = new WorkexAdapter(getActivity(), por);
                rv.setItemAnimator(new DefaultItemAnimator());
                rv.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<WorkexModel>> call, Throwable t) {
            }
        });

        return myView;
    }
}
