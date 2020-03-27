package com.example.coronacd.apiservice;

import com.example.coronacd.model.CoronaDetailModel;
import com.example.coronacd.model.CoronaModel;
import com.example.coronacd.model.GlobalModel;
import com.example.coronacd.model.OverallModel;

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

    @GET("/positif")
    Call<OverallModel> getPositif();

    @GET("/sembuh")
    Call<OverallModel> getSembuh();

    @GET("/meninggal")
    Call<OverallModel> getMeninggal();

}
