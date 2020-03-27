package com.example.coronacd.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoronaResponse {
    @SerializedName("")
    public CoronaModel coronaModel;
    private List<CoronaResponse> results;

    public CoronaModel getCoronaModel() {
        return coronaModel;
    }

    public List<CoronaResponse> getResults() {
        return results;
    }
}
