package com.example.coronacd;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GlobalModel implements Parcelable {
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;

    protected GlobalModel(Parcel in) {
    }

    public static final Creator<GlobalModel> CREATOR = new Creator<GlobalModel>() {
        @Override
        public GlobalModel createFromParcel(Parcel in) {
            return new GlobalModel(in);
        }

        @Override
        public GlobalModel[] newArray(int size) {
            return new GlobalModel[size];
        }
    };

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
