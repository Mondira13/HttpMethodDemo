package com.example.enc.httpmethoddemo;

import com.example.enc.httpmethoddemo.pojo.FormSubmitResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("/testform.php")
    Call<FormSubmitResponse> setFormValues(@Field("mobile") String mobile,@Field("name") String name);


//    @POST("/bins/d80tw")
//    Call<DashboardResponse> getDashboardItemsp();


}
