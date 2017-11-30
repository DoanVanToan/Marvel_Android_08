package com.it.hungvt.movieapp.data.model;

import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.it.hungvt.movieapp.utils.Constant;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Mapping data Model form Json return */
public class Movie extends BaseModel implements Parcelable {

    @SerializedName("original_title")
    @Expose
    private String mTitle;
    @SerializedName("vote_average")
    @Expose
    private float mVoteAverage;
    @SerializedName("poster_path")
    @Expose
    private String mPosterPath;
    @SerializedName("overview")
    @Expose
    private String mOverview;
    @SerializedName("release_date")
    @Expose
    private Date mReleaseDate;

    public Movie(Parcel in) {
        setId(in.readInt());
        mTitle = in.readString();
        mVoteAverage = in.readFloat();
        mPosterPath = in.readString();
        mOverview = in.readString();
        mReleaseDate = new Date(in.readLong());
    }

    public Movie(String title, Float voteAverage, String posterPath) {
        mTitle = title;
        mVoteAverage = voteAverage;
        mPosterPath = posterPath;
    }

    @Bindable
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    @Bindable
    public float getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        mVoteAverage = voteAverage;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public Date getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        mReleaseDate = releaseDate;
    }

    @Bindable
    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    @Bindable
    public String getDate() {
        SimpleDateFormat dt = new SimpleDateFormat(Constant.FORMAT_DATE, Locale.US);
        return dt.format(mReleaseDate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getId());
        parcel.writeString(mTitle);
        parcel.writeFloat(mVoteAverage);
        parcel.writeString(mPosterPath);
        parcel.writeString(mOverview);
        parcel.writeLong(mReleaseDate.getTime());
    }
}
