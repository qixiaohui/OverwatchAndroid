package com.infi.overwatch.overwatchandroid.model.Video;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Channel {

    @SerializedName("mature")
    @Expose
    private Boolean mature;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("broadcaster_language")
    @Expose
    private String broadcasterLanguage;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("game")
    @Expose
    private String game;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("_id")
    @Expose
    private Integer Id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("delay")
    @Expose
    private Object delay;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("banner")
    @Expose
    private Object banner;
    @SerializedName("video_banner")
    @Expose
    private String videoBanner;
    @SerializedName("background")
    @Expose
    private Object background;
    @SerializedName("profile_banner")
    @Expose
    private String profileBanner;
    @SerializedName("profile_banner_background_color")
    @Expose
    private Object profileBannerBackgroundColor;
    @SerializedName("partner")
    @Expose
    private Boolean partner;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("followers")
    @Expose
    private Integer followers;
    @SerializedName("_links")
    @Expose
    private Links_ Links;

    /**
     *
     * @return
     * The mature
     */
    public Boolean getMature() {
        return mature;
    }

    /**
     *
     * @param mature
     * The mature
     */
    public void setMature(Boolean mature) {
        this.mature = mature;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The broadcasterLanguage
     */
    public String getBroadcasterLanguage() {
        return broadcasterLanguage;
    }

    /**
     *
     * @param broadcasterLanguage
     * The broadcaster_language
     */
    public void setBroadcasterLanguage(String broadcasterLanguage) {
        this.broadcasterLanguage = broadcasterLanguage;
    }

    /**
     *
     * @return
     * The displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     *
     * @param displayName
     * The display_name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     *
     * @return
     * The game
     */
    public String getGame() {
        return game;
    }

    /**
     *
     * @param game
     * The game
     */
    public void setGame(String game) {
        this.game = game;
    }

    /**
     *
     * @return
     * The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     *
     * @param language
     * The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     *
     * @return
     * The Id
     */
    public Integer getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The _id
     */
    public void setId(Integer Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     * The delay
     */
    public Object getDelay() {
        return delay;
    }

    /**
     *
     * @param delay
     * The delay
     */
    public void setDelay(Object delay) {
        this.delay = delay;
    }

    /**
     *
     * @return
     * The logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     *
     * @param logo
     * The logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     *
     * @return
     * The banner
     */
    public Object getBanner() {
        return banner;
    }

    /**
     *
     * @param banner
     * The banner
     */
    public void setBanner(Object banner) {
        this.banner = banner;
    }

    /**
     *
     * @return
     * The videoBanner
     */
    public String getVideoBanner() {
        return videoBanner;
    }

    /**
     *
     * @param videoBanner
     * The video_banner
     */
    public void setVideoBanner(String videoBanner) {
        this.videoBanner = videoBanner;
    }

    /**
     *
     * @return
     * The background
     */
    public Object getBackground() {
        return background;
    }

    /**
     *
     * @param background
     * The background
     */
    public void setBackground(Object background) {
        this.background = background;
    }

    /**
     *
     * @return
     * The profileBanner
     */
    public String getProfileBanner() {
        return profileBanner;
    }

    /**
     *
     * @param profileBanner
     * The profile_banner
     */
    public void setProfileBanner(String profileBanner) {
        this.profileBanner = profileBanner;
    }

    /**
     *
     * @return
     * The profileBannerBackgroundColor
     */
    public Object getProfileBannerBackgroundColor() {
        return profileBannerBackgroundColor;
    }

    /**
     *
     * @param profileBannerBackgroundColor
     * The profile_banner_background_color
     */
    public void setProfileBannerBackgroundColor(Object profileBannerBackgroundColor) {
        this.profileBannerBackgroundColor = profileBannerBackgroundColor;
    }

    /**
     *
     * @return
     * The partner
     */
    public Boolean getPartner() {
        return partner;
    }

    /**
     *
     * @param partner
     * The partner
     */
    public void setPartner(Boolean partner) {
        this.partner = partner;
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
     * The views
     */
    public Integer getViews() {
        return views;
    }

    /**
     *
     * @param views
     * The views
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     *
     * @return
     * The followers
     */
    public Integer getFollowers() {
        return followers;
    }

    /**
     *
     * @param followers
     * The followers
     */
    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    /**
     *
     * @return
     * The Links
     */
    public Links_ getLinks() {
        return Links;
    }

    /**
     *
     * @param Links
     * The _links
     */
    public void setLinks(Links_ Links) {
        this.Links = Links;
    }

}
