package com.example.coronacd.viewmodel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.coronacd.apiservice.ApiCorona;
import com.example.coronacd.model.CoronaDetailModel;
import com.example.coronacd.model.CoronaModel;
import com.example.coronacd.model.GlobalModel;
import com.example.coronacd.model.OverallModel;
import com.example.coronacd.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoronaViewModel extends ViewModel {
    private MutableLiveData<List<CoronaModel>> listCorona = new MutableLiveData<>();
    private MutableLiveData<List<GlobalModel>> listGlobal = new MutableLiveData<>();
    private MutableLiveData<List<CoronaDetailModel>> listDetail = new MutableLiveData<>();
    private MutableLiveData<OverallModel> positif = new MutableLiveData<>();
    private MutableLiveData<OverallModel> sembuh = new MutableLiveData<>();
    private MutableLiveData<OverallModel> meninggal = new MutableLiveData<>();

    public LiveData<List<CoronaModel>> getCorona(Context context) {
        Log.e("asdasda", "asdasda");
        Coba(context);
//        LoadIndoData(context);
        return listCorona;
    }

    public LiveData<List<GlobalModel>> getGlobal() {
        Log.e("Loading", "GlobalData");
        LoadGlobalData();
        return listGlobal;
    }

    public LiveData<List<GlobalModel>> getMap(List<GlobalModel> list) {
        Log.e("Loading", "GlobalData");
        LoadGlobalData();
        listGlobal.postValue(list);
        return listGlobal;
    }

    public LiveData<List<CoronaDetailModel>> getDetali() {
        LoadIndoData();
        return listDetail;
    }

    public LiveData<OverallModel> getPositif() {
        Log.e("Loading", "GetPositif");
        LoadPositif();

        return positif;
    }

    public LiveData<OverallModel> getSembuh() {
        LoadSembuh();
        return sembuh;
    }

    public LiveData<OverallModel> getMeninggal() {
        LoadMeninggal();
        return meninggal;
    }

    private void Coba(Context context) {
        final ApiCorona api = RetrofitService.createService(ApiCorona.class);
        Call<List<CoronaModel>> call = api.getData();
        call.enqueue(new Callback<List<CoronaModel>>() {
            @Override
            public void onResponse(Call<List<CoronaModel>> call, Response<List<CoronaModel>> response) {
                listCorona.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CoronaModel>> call, Throwable t) {
                Toast.makeText(context, "Error Occurred", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void LoadPositif() {
        final ApiCorona api = RetrofitService.createService(ApiCorona.class);
        Call<OverallModel> call = api.getPositif();
        call.enqueue(new Callback<OverallModel>() {
            @Override
            public void onResponse(Call<OverallModel> call, Response<OverallModel> response) {
                OverallModel listo = response.body();
                Log.e("Testing", listo.getValue());
                positif.setValue(response.body());

            }

            @Override
            public void onFailure(Call<OverallModel> call, Throwable t) {
                Log.e("Error", "Errorrrrr");
            }
        });
    }

    private void LoadSembuh() {
        final ApiCorona api = RetrofitService.createService(ApiCorona.class);
        Call<OverallModel> call = api.getSembuh();
        call.enqueue(new Callback<OverallModel>() {
            @Override
            public void onResponse(Call<OverallModel> call, Response<OverallModel> response) {
                sembuh.setValue(response.body());
            }

            @Override
            public void onFailure(Call<OverallModel> call, Throwable t) {
                Log.e("Error", "Errorrrrr");
            }
        });
    }

    private void LoadMeninggal() {
        final ApiCorona api = RetrofitService.createService(ApiCorona.class);
        Call<OverallModel> call = api.getMeninggal();
        call.enqueue(new Callback<OverallModel>() {
            @Override
            public void onResponse(Call<OverallModel> call, Response<OverallModel> response) {
                meninggal.setValue(response.body());
            }

            @Override
            public void onFailure(Call<OverallModel> call, Throwable t) {
                Log.e("Error", "Errorrrrr");
            }
        });
    }

    private void LoadIndoData() {
        final ApiCorona api = RetrofitService.createService(ApiCorona.class);
        Call<List<CoronaDetailModel>> call = api.getDetail();
        call.enqueue(new Callback<List<CoronaDetailModel>>() {
            @Override
            public void onResponse(Call<List<CoronaDetailModel>> call, Response<List<CoronaDetailModel>> response) {
                List<CoronaDetailModel> list = response.body();

                listDetail.setValue(list);
            }

            @Override
            public void onFailure(Call<List<CoronaDetailModel>> call, Throwable t) {

            }
        });
    }

    private void LoadGlobalData() {
        final ApiCorona api = RetrofitService.createService(ApiCorona.class);
        Call<List<GlobalModel>> call = api.getGlobal();
        call.enqueue(new Callback<List<GlobalModel>>() {
            @Override
            public void onResponse(Call<List<GlobalModel>> call, Response<List<GlobalModel>> response) {
                List<GlobalModel> temp = response.body();
                listGlobal.setValue(temp);
            }

            @Override
            public void onFailure(Call<List<GlobalModel>> call, Throwable t) {
                Log.e("eree", t.toString());
            }
        });
    }
}
