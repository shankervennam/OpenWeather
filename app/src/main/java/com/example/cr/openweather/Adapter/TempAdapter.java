package com.example.cr.openweather.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cr.openweather.Model.Temp;
import com.example.cr.openweather.R;

import java.util.List;

public class TempAdapter extends RecyclerView.Adapter<TempAdapter.TempViewHolder>
{
    private List<Temp.Weather> weather;

    private int rowLayout;
    private Context context;

    public TempAdapter(List<Temp.Weather> weather, int rowLayout, Context context)
    {
        this.weather = weather;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public TempViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new TempViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TempViewHolder holder, int position)
    {
//        holder.id.setText(weather.get(position).getDt().toString());
//        holder.main.setText(weather.get(position).getDtTxt().toString());
        holder.id.setText(weather.get(position).getId().toString());
        holder.main.setText(weather.get(position).getMain().toString());
        holder.desc.setText(weather.get(position).getDescription().toString());
        holder.icon.setText(weather.get(position).getIcon().toString());
    }

    @Override
    public int getItemCount()
    {
        return weather.size();
    }

    public static class TempViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout linearLayout;
        TextView id;
        TextView main;
        TextView desc;
        TextView icon;

        public TempViewHolder(View itemView)
        {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.temp_layout);
            id= (TextView) itemView.findViewById(R.id.text_id);
            main = (TextView) itemView.findViewById(R.id.text_main);
            desc= (TextView) itemView.findViewById(R.id.text_desc);
            icon = (TextView) itemView.findViewById(R.id.text_icon);
        }
    }
}
