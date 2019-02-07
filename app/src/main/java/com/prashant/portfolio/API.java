package com.prashant.portfolio;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("/about")
    Call<User> aboutMe();
}