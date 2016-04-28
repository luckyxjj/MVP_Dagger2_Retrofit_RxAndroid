package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hwj3747 on 2016/4/5.
 */
public class TestEntity implements Parcelable {
    String name;
    String pwd;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.pwd);
    }

    public TestEntity() {
    }

    protected TestEntity(Parcel in) {
        this.name = in.readString();
        this.pwd = in.readString();
    }

    public static final Parcelable.Creator<TestEntity> CREATOR = new Parcelable.Creator<TestEntity>() {
        @Override
        public TestEntity createFromParcel(Parcel source) {
            return new TestEntity(source);
        }

        @Override
        public TestEntity[] newArray(int size) {
            return new TestEntity[size];
        }
    };
}
