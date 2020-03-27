package com.example.coronacd.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OverallModel implements Parcelable {
    public static final Creator<OverallModel> CREATOR = new Creator<OverallModel>() {
        @Override
        public OverallModel createFromParcel(Parcel in) {
            return new OverallModel(in);
        }

        @Override
        public OverallModel[] newArray(int size) {
            return new OverallModel[size];
        }
    };
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private String value;

    protected OverallModel(Parcel in) {
        name = in.readString();
        value = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(value);
    }
}
