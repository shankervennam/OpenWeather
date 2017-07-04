package com.example.cr.openweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.cr.openweather.Adapter.TempAdapter;
import com.example.cr.openweather.Model.Temp;
import com.example.cr.openweather.Retrofit.ApiClient;
import com.example.cr.openweather.Retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);

        Call<Temp> call = apiInterface.getWeather();
        call.enqueue(new Callback<Temp>()
        {
            @Override
            public void onResponse(Call<Temp> call, Response<Temp> response)
            {
                response.body();
                List<Temp.Weather> temp = response.body().getListTemp().get(0).getWeather();
                recyclerView.setAdapter(new TempAdapter(temp, R.layout.list_row, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<Temp> call, Throwable t)
            {
                Log.e(TAG, t.toString());
            }
        });
    }
}
