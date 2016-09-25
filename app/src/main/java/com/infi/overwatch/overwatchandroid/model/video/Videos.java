package com.infi.overwatch.overwatchandroid.model.video;

/**
 * Created by qixiaohui on 9/24/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Videos {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("videoId")
    @Expose
    private String videoId;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("watchTime")
    @Expose
    private Integer watchTime;
    @SerializedName("likeTime")
    @Expose
    private Integer likeTime;
    @SerializedName("dislikeTime")
    @Expose
    private Integer dislikeTime;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("publishedTime")
    @Expose
    private String publishedTime;
    @SerializedName("playlistId")
    @Expose
    private String playlistId;
    @SerializedName("channelId")
    @Expose
    private String channelId;
    @SerializedName("urlFull")
    @Expose
    private String urlFull;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The _id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The videoId
     */
    public String getVideoId() {
        return videoId;
    }

    /**
     *
     * @param videoId
     * The videoId
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    /**
     *
     * @return
     * The source
     */
    public String getSource() {
        return source;
    }

    /**
     *
     * @param source
     * The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     *
     * @return
     * The watchTime
     */
    public Integer getWatchTime() {
        return watchTime;
    }

    /**
     *
     * @param watchTime
     * The watchTime
     */
    public void setWatchTime(Integer watchTime) {
        this.watchTime = watchTime;
    }

    /**
     *
     * @return
     * The likeTime
     */
    public Integer getLikeTime() {
        return likeTime;
    }

    /**
     *
     * @param likeTime
     * The likeTime
     */
    public void setLikeTime(Integer likeTime) {
        this.likeTime = likeTime;
    }

    /**
     *
     * @return
     * The dislikeTime
     */
    public Integer getDislikeTime() {
        return dislikeTime;
    }

    /**
     *
     * @param dislikeTime
     * The dislikeTime
     */
    public void setDislikeTime(Integer dislikeTime) {
        this.dislikeTime = dislikeTime;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The publishedTime
     */
    public String getPublishedTime() {
        return publishedTime;
    }

    /**
     *
     * @param publishedTime
     * The publishedTime
     */
    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    /**
     *
     * @return
     * The playlistId
     */
    public String getPlaylistId() {
        return playlistId;
    }

    /**
     *
     * @param playlistId
     * The playlistId
     */
    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    /**
     *
     * @return
     * The channelId
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     *
     * @param channelId
     * The channelId
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     *
     * @return
     * The urlFull
     */
    public String getUrlFull() {
        return urlFull;
    }

    /**
     *
     * @param urlFull
     * The urlFull
     */
    public void setUrlFull(String urlFull) {
        this.urlFull = urlFull;
    }

}