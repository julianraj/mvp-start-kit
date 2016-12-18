package com.julianraj.mvpstartkit.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by julian on 12/17/16.
 */

public class TestModel implements Parcelable{
    @SerializedName("id")
    Long id;
    @SerializedName("title")
    String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.title);
    }

    public TestModel() {
    }

    protected TestModel(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.title = in.readString();
    }

    public static final Creator<TestModel> CREATOR = new Creator<TestModel>() {
        @Override
        public TestModel createFromParcel(Parcel source) {
            return new TestModel(source);
        }

        @Override
        public TestModel[] newArray(int size) {
            return new TestModel[size];
        }
    };
}
