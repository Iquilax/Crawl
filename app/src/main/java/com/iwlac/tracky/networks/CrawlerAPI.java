package com.iwlac.tracky.networks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by buupv on 4/4/17.
 */

public interface CrawlerAPI {
    @GET("getProducts")
    Call<String> getProductID(@Query("productName") String name);
}
