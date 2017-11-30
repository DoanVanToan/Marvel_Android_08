package com.it.hungvt.movieapp.utils;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.it.hungvt.movieapp.utils.TabTypeName.NOW_PLAYING;
import static com.it.hungvt.movieapp.utils.TabTypeName.POPULAR;
import static com.it.hungvt.movieapp.utils.TabTypeName.TOP_RATE;
import static com.it.hungvt.movieapp.utils.TabTypeName.UP_COMING;

/**
 * Tab title type name
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({ TOP_RATE, UP_COMING, NOW_PLAYING, POPULAR })
public @interface TabTypeName {
    int TOP_RATE = 0;
    int UP_COMING = 1;
    int NOW_PLAYING = 2;
    int POPULAR = 3;
}
