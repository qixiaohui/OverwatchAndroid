package com.infi.overwatch.overwatchandroid.model.video;

/**
 * Created by qixiaohui on 9/24/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("pageIndex")
    @Expose
    private Integer pageIndex;
    @SerializedName("videoNum")
    @Expose
    private Integer videoNum;

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
     * The pageIndex
     */
    public Integer getPageIndex() {
        return pageIndex;
    }

    /**
     *
     * @param pageIndex
     * The pageIndex
     */
    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     *
     * @return
     * The videoNum
     */
    public Integer getVideoNum() {
        return videoNum;
    }

    /**
     *
     * @param videoNum
     * The videoNum
     */
    public void setVideoNum(Integer videoNum) {
        this.videoNum = videoNum;
    }

}
