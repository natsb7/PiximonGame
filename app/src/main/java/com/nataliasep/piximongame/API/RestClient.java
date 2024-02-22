package com.nataliasep.piximongame.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static IAPIService apiInstance;
    //private static final String BASE_URL = "http://192.168.50.135:8081";
    private static final String BASE_URL = "https://localhost:8081";

    private RestClient() {
    }

    public synchronized static IAPIService getApiServiceInstance() {
        if (apiInstance == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInstance = retrofit.create(IAPIService.class);
        }
        return apiInstance;
    }
}
