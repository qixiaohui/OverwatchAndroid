package com.infi.overwatch.overwatchandroid.model.heroDetail;

/**
 * Created by TQi on 6/14/16.
 */

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Abilities {

    @SerializedName("name")
    @Expose
    private List<String> name = new ArrayList<String>();
    @SerializedName("desc")
    @Expose
    private List<String> desc = new ArrayList<String>();

    /**
     *
     * @return
     * The name
     */
    public List<String> getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(List<String> name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The desc
     */
    public List<String> getDesc() {
        return desc;
    }

    /**
     *
     * @param desc
     * The desc
     */
    public void setDesc(List<String> desc) {
        this.desc = desc;
    }

}
