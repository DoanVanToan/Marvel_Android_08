package com.it.hungvt.movieapp.data.model;

import android.databinding.BaseObservable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* Define data using generic for classes Model */
public class BaseModel extends BaseObservable{
    @SerializedName("id")
    @Expose
    private int mId;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
}
