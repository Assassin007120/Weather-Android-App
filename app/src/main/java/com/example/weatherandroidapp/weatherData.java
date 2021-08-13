package com.example.weatherandroidapp;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherData {

    private String mTemperature,mIcon,mcity,mWeatherType;
    private int mCondition;

    public static weatherData fromJson(JSONObject jsonObject){
        try{
            weatherData weatherD=new weatherData();
            weatherD.mcity=jsonObject.getString("name");
            weatherD.mCondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.mIcon=updateWeatherIcon(weatherD.mCondition);
            double tempResult=jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue=(int)Math.rint(tempResult);
            weatherD.mTemperature=Integer.toString(roundedValue);
            return weatherD;
        }
        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String updateWeatherIcon(int condition)
    {
        if(condition>=0 && condition<=300){
            return "thunder"; //thunder
        }
        else if(condition>=300 && condition<=500){
            return "lightrain"; //light rain
        }
        else if(condition>=500 && condition<=700){
            return "showers"; //showers
        }
        else if(condition>=600 && condition<=700){
            return "heavysnow"; //heavy snow
        }
        else if(condition>=701 && condition<=771){
            return "fog"; //fog
        }
        else if(condition>=772 && condition<=800){
            return "overcast"; //overcast
        }
        else if(condition>=800){
            return "sunny"; //sunny
        }
        else if(condition>=801 && condition<=804){
            return "cloudy"; //cloudy
        }
        else if(condition>=900 && condition<=902){
            return "thunderstorm"; //thunderstorm
        }
        else if(condition>=903){
            return "lightsnow"; //light snow
        }
        else if(condition>=904){
            return "sunny"; //sunny
        }
        else if(condition>=905 && condition<=1000){
            return "thunderstorm"; //thunderstorm
        }

        return "dunno";

    }

    public String getmTemperature(){
        return mTemperature+"°C";
    }

    public String getmIcon(){
        return mIcon;
    }

    public String getMcity(){
        return mcity;
    }

    public String getmWeatherType(){
        return mWeatherType;
    }

}
