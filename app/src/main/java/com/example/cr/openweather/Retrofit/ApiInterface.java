package com.example.cr.openweather.Retrofit;

import com.example.cr.openweather.Model.Temp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface
{
    @GET("forecast?id=524901&appid=b1b15e88fa797225412429c1c50c122a1")
    Call<Temp> getWeather();
}