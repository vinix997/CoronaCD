package com.example.coronacd.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AttributeDetail implements Parcelable {

    public static final Creator<AttributeDetail> CREATOR = new Creator<AttributeDetail>() {
        @Override
        public AttributeDetail createFromParcel(Parcel in) {
            return new AttributeDetail(in);
        }

        @Override
        public AttributeDetail[] newArray(int size) {
            return new AttributeDetail[size];
        }
    };
    @SerializedName("Provinsi")
    private String provinsi;
    @SerializedName("Kasus_Posi")
    private int kasusPos;
    @SerializedName("Kasus_Semb")
    private int kasusSem;
    @SerializedName("Kasus_Meni")
    private int kasusMeni;

    protected AttributeDetail(Parcel in) {
        provinsi = in.readString();
        kasusPos = in.readInt();
        kasusSem = in.readInt();
        kasusMeni = in.readInt();
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public int getKasusPos() {
        return kasusPos;
    }

    public void setKasusPos(int kasusPos) {
        this.kasusPos = kasusPos;
    }

    public int getKasusSem() {
        return kasusSem;
    }

    public void setKasusSem(int kasusSem) {
        this.kasusSem = kasusSem;
    }

    public int getKasusMeni() {
        return kasusMeni;
    }

    public void setKasusMeni(int kasusMeni) {
        this.kasusMeni = kasusMeni;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(provinsi);
        parcel.writeInt(kasusPos);
        parcel.writeInt(kasusSem);
        parcel.writeInt(kasusMeni);
    }
}
