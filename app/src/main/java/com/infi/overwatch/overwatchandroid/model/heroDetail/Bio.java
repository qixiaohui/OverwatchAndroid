package com.infi.overwatch.overwatchandroid.model.heroDetail;

/**
 * Created by TQi on 6/14/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bio {

    @SerializedName("realname")
    @Expose
    private String realname;
    @SerializedName("occupation")
    @Expose
    private String occupation;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("affiliation")
    @Expose
    private String affiliation;

    /**
     *
     * @return
     * The realname
     */
    public String getRealname() {
        return realname;
    }

    /**
     *
     * @param realname
     * The realname
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     *
     * @return
     * The occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     *
     * @param occupation
     * The occupation
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     *
     * @return
     * The base
     */
    public String getBase() {
        return base;
    }

    /**
     *
     * @param base
     * The base
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     *
     * @return
     * The affiliation
     */
    public String getAffiliation() {
        return affiliation;
    }

    /**
     *
     * @param affiliation
     * The affiliation
     */
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

}
