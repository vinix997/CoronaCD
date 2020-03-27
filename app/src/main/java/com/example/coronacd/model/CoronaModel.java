package com.example.coronacd.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CoronaModel implements Parcelable {

    public static final Creator<CoronaModel> CREATOR = new Creator<CoronaModel>() {
        @Override
        public CoronaModel createFromParcel(Parcel in) {
            return new CoronaModel(in);
        }

        @Override
        public CoronaModel[] newArray(int size) {
            return new CoronaModel[size];
        }
    };
    @SerializedName("name")
    private String name;
    @SerializedName("positif")
    private String positif;
    @SerializedName("sembuh")
    private String sembuh;
    @SerializedName("meninggal")
    private String meninggal;

    protected CoronaModel(Parcel in) {
    }

    public String getPositif() {
        return positif;
    }

    public void setPositif(String positif) {
        this.positif = positif;
    }

    public String getSembuh() {
        return sembuh;
    }

    public void setSembuh(String sembuh) {
        this.sembuh = sembuh;
    }

    public String getMeninggal() {
        return meninggal;
    }

    public void setMeninggal(String meninggal) {
        this.meninggal = meninggal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
