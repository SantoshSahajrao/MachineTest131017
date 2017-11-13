package com.example.ravi.machinetest13_10_17;

import java.io.Serializable;

/**
 * Created by ravi on 13/11/17.
 */

public class Data implements Serializable {

    String mName,mAddress,Icon;
    int mRating;

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String icon) {
        Icon = icon;
    }


    double lat,lao;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public int getmRating() {
        return mRating;
    }

    public void setmRating(int mRating) {
        this.mRating = mRating;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLao() {
        return lao;
    }

    public void setLao(double lao) {
        this.lao = lao;
    }
}
