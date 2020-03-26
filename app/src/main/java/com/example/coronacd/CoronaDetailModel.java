package com.example.coronacd;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CoronaDetailModel implements Parcelable {
    public static final Creator<CoronaDetailModel> CREATOR = new Creator<CoronaDetailModel>() {
        @Override
        public CoronaDetailModel createFromParcel(Parcel in) {
            return new CoronaDetailModel(in);
        }

        @Override
        public CoronaDetailModel[] newArray(int size) {
            return new CoronaDetailModel[size];
        }
    };
    @SerializedName("attributes")
    private AttributeDetail attributeDetail;

    protected CoronaDetailModel(Parcel in) {
    }

    public AttributeDetail getAttributeDetail() {
        return attributeDetail;
    }

    public void setAttributeDetail(AttributeDetail attributeDetail) {
        this.attributeDetail = attributeDetail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
