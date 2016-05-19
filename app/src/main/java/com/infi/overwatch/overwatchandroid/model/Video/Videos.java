package com.infi.overwatch.overwatchandroid.model.Video;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Videos {

    @SerializedName("streams")
    @Expose
    private List<Stream> streams = new ArrayList<Stream>();
    @SerializedName("_total")
    @Expose
    private Integer Total;
    @SerializedName("_links")
    @Expose
    private Links__ Links;

    /**
     *
     * @return
     * The streams
     */
    public List<Stream> getStreams() {
        return streams;
    }

    /**
     *
     * @param streams
     * The streams
     */
    public void setStreams(List<Stream> streams) {
        this.streams = streams;
    }

    /**
     *
     * @return
     * The Total
     */
    public Integer getTotal() {
        return Total;
    }

    /**
     *
     * @param Total
     * The _total
     */
    public void setTotal(Integer Total) {
        this.Total = Total;
    }

    /**
     *
     * @return
     * The Links
     */
    public Links__ getLinks() {
        return Links;
    }

    /**
     *
     * @param Links
     * The _links
     */
    public void setLinks(Links__ Links) {
        this.Links = Links;
    }

}