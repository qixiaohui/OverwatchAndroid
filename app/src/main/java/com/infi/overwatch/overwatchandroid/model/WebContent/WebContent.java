package com.infi.overwatch.overwatchandroid.model.WebContent;

/**
 * Created by TQi on 5/19/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WebContent {

    @SerializedName("content")
    @Expose
    private String content;

    /**
     *
     * @return
     * The content
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @param content
     * The content
     */
    public void setContent(String content) {
        this.content = content;
    }

}
