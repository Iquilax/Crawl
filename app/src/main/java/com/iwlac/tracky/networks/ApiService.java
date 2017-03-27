package com.iwlac.tracky.networks;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iwlac.tracky.utility.NetworkConstant;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by buupv on 3/25/17.
 */

public class ApiService {
    private static ApiService mInstance = null;
    public static ApiService getInstance() {
        if (mInstance == null) {
            mInstance = getRetrofit().create(ApiService.class);
        }

        return mInstance;
    }

    private static Retrofit getRetrofit() {

        // Customise Gson instance
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        // Create Retrofit instance
        return new Retrofit.Builder()
                .baseUrl(NetworkConstant.API_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

}
