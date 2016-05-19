package com.infi.overwatch.overwatchandroid.Dao;

import com.infi.overwatch.overwatchandroid.model.Video.Videos;
import com.infi.overwatch.overwatchandroid.model.heros.Heros;
import com.infi.overwatch.overwatchandroid.model.table.Table;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface Gateway {

    @GET("news/{tablename}")
    Call<Table> getTable(@Path("tablename") String tablename, @Header("pagination") String pagination,@Header("language") String language);

    @GET("heros/allheros")
    Call<ArrayList<Heros>> getHeros();

    @GET("streams?game=overwatch")
    Call<Videos> getVideos();
}
