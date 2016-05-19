package com.infi.overwatch.overwatchandroid.model.heros;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Heros {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("heroname")
    @Expose
    private String heroname;
    @SerializedName("imgPath")
    @Expose
    private String imgPath;

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

}
