package com.it.hungvt.movieapp.utils;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.it.hungvt.movieapp.utils.TabTypeName.NOW_PLAYING;
import static com.it.hungvt.movieapp.utils.TabTypeName.POPULAR;
import static com.it.hungvt.movieapp.utils.TabTypeName.TOP_RATE;
import static com.it.hungvt.movieapp.utils.TabTypeName.UP_COMING;

@Retention(RetentionPolicy.SOURCE)
@IntDef({TOP_RATE,UP_COMING,NOW_PLAYING,POPULAR})
public @interface TabTypeName{
    public static final int TOP_RATE = 0;
    public static final int UP_COMING = 1;
    public static final int NOW_PLAYING = 2;
    public static final int POPULAR = 3;
}
