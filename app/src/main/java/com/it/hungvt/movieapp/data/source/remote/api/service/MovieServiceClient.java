package com.it.hungvt.movieapp.data.source.remote.api.service;

import com.it.hungvt.movieapp.utils.Constant;
/* Create Singleton Retrofit */

public class MovieServiceClient extends ServiceClient {

    private static MovieApi sMovieApi;

    public static MovieApi getInstance() {
        if (sMovieApi == null) {
            sMovieApi = createService(Constant.END_POINT_URL, MovieApi.class);
        }
        return sMovieApi;
    }
}
