package com.prashant.portfolio;

import com.prashant.portfolio.AboutMe.AboutMeDC;
import com.prashant.portfolio.Education.HigherStudiesDC;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("/about")
    Call<AboutMeDC> aboutMe();

    @GET("/education")
    Call<HigherStudiesDC> education();
}