package com.example.cr.openweather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Temp
{
    @SerializedName("list")
    public List<ListTemp> listTemp;

    public List<ListTemp> getListTemp() {
        return listTemp;
    }

    public class ListTemp {

        @SerializedName("weather")
        @Expose
        private List<Weather> weather;

        public List<Weather> getWeather() {
            return weather;
        }
    }

    public class Weather {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("main")
        @Expose
        private String main;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("icon")
        @Expose
        private String icon;

        public Integer getId() {
            return id;
        }

        public String getMain() {
            return main;
        }

        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }
    }
}
