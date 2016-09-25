package com.infi.overwatch.overwatchandroid.Dao;

import com.infi.overwatch.overwatchandroid.model.WebContent.WebContent;
import com.infi.overwatch.overwatchandroid.model.heroDetail.HeroDetail;
import com.infi.overwatch.overwatchandroid.model.heros.Heros;
import com.infi.overwatch.overwatchandroid.model.table.Table;
import com.infi.overwatch.overwatchandroid.model.video.VideoPayload;
import com.infi.overwatch.overwatchandroid.model.video.Videos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Gateway {

    @GET("news/{tablename}")
    Call<Table> getTable(@Path("tablename") String tablename, @Header("pagination") String pagination,@Header("language") String language);

    @GET("hero/allHeros")
    Call<ArrayList<Heros>> getHeros();

    @GET("content")
    Call<List<WebContent>> getWebContent(@Header("link") String link,@Header("id") String id);

    @GET("hero/heroDetail/{id}")
    Call<HeroDetail> getHeroDetail(@Path("id") String heroName);

    @Headers({"Content-Type: application/json"})
    @POST("video/getAllVideos")
    Call<ArrayList<Videos>> getVideos(@Body VideoPayload videoPayload);
}
