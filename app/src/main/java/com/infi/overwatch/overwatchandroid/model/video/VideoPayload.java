package com.infi.overwatch.overwatchandroid.model.video;

/**
 * Created by qixiaohui on 9/24/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoPayload {

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("timeout")
    @Expose
    private Integer timeout;

    /**
     *
     * @return
     * The data
     */
    public Data getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(Data data) {
        this.data = data;
    }

    /**
     *
     * @return
     * The timeout
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     *
     * @param timeout
     * The timeout
     */
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

}
