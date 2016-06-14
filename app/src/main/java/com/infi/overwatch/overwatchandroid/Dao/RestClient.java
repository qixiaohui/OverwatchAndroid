package com.infi.overwatch.overwatchandroid.Dao;

/**
 * Created by TQi on 5/18/16.
 */
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    static final String baseUrl = "http://polar-sands-49796.herokuapp.com/";
    static final String twitchBaseUrl = "https://api.twitch.tv/kraken/";
    static final String awsUrl = "http://ec2-52-39-92-64.us-west-2.compute.amazonaws.com/";

    public static Gateway getGateway(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Gateway.class);
    }

    public static Gateway getAwsGateway(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(awsUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Gateway.class);
    }

    public static Gateway getTwitchGateway(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(twitchBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Gateway.class);
    }
}
