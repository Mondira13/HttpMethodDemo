package com.example.enc.httpmethoddemo;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    static Retrofit getClient() {


        OkHttpClient client = new OkHttpClient.Builder().build();


        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.10.33")
                .addConverterFactory(GsonConverterFactory.create()) // convert string to object
                .client(client) // its a http client object
                .build();


        return retrofit; // its create for call api
    }




//    https://api.myjson.com/bins/1cwbec

}
