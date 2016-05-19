package com.infi.overwatch.overwatchandroid.model.Video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links__ {

    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("featured")
    @Expose
    private String featured;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("followed")
    @Expose
    private String followed;

    /**
     *
     * @return
     * The self
     */
    public String getSelf() {
        return self;
    }

    /**
     *
     * @param self
     * The self
     */
    public void setSelf(String self) {
        this.self = self;
    }

    /**
     *
     * @return
     * The next
     */
    public String getNext() {
        return next;
    }

    /**
     *
     * @param next
     * The next
     */
    public void setNext(String next) {
        this.next = next;
    }

    /**
     *
     * @return
     * The featured
     */
    public String getFeatured() {
        return featured;
    }

    /**
     *
     * @param featured
     * The featured
     */
    public void setFeatured(String featured) {
        this.featured = featured;
    }

    /**
     *
     * @return
     * The summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     *
     * @param summary
     * The summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     *
     * @return
     * The followed
     */
    public String getFollowed() {
        return followed;
    }

    /**
     *
     * @param followed
     * The followed
     */
    public void setFollowed(String followed) {
        this.followed = followed;
    }

}
