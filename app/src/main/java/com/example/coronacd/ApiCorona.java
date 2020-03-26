package com.example.coronacd;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCorona {
    @GET("/indonesia")
    Call<List<CoronaModel>> getData();

    @GET("/indonesia/provinsi")
    Call<List<CoronaDetailModel>> getDetail();

    @GET("/")
    Call<List<GlobalModel>> getGlobal();

}
