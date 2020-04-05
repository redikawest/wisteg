package com.example.wisteg.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    /**
     *
     * Created by root on 2/3/17.
     */

    public class ApiClient {
        public static final String BASE_URL = "https://my-json-server.typicode.com/redikawest/wisata/";
        private static Retrofit retrofit = null;
        public static Retrofit getClient() {
            if (retrofit==null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }
    }

