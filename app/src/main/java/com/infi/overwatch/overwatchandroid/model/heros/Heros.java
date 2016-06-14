package com.infi.overwatch.overwatchandroid.model.heros;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Heros {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("heroname")
    @Expose
    private String heroname;
    @SerializedName("imgPath")
    @Expose
    private String imgPath;
    @SerializedName("likeTime")
    @Expose
    private Integer likeTime;
    @SerializedName("dislikeTime")
    @Expose
    private Integer dislikeTime;

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
     * The key
     */
    public String getKey() {
        return key;
    }

    /**
     *
     * @param key
     * The key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     *
     * @return
     * The heroname
     */
    public String getHeroname() {
        return heroname;
    }

    /**
     *
     * @param heroname
     * The heroname
     */
    public void setHeroname(String heroname) {
        this.heroname = heroname;
    }

    /**
     *
     * @return
     * The imgPath
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     *
     * @param imgPath
     * The imgPath
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
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

}
