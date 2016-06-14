package com.infi.overwatch.overwatchandroid.model.heroDetail;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeroDetail {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("poster")
    @Expose
    private String poster;
    @SerializedName("description")
    @Expose
    private List<String> description = new ArrayList<String>();
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("bio")
    @Expose
    private Bio bio;
    @SerializedName("abilities")
    @Expose
    private Abilities abilities;

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
     * The poster
     */
    public String getPoster() {
        return poster;
    }

    /**
     *
     * @param poster
     * The poster
     */
    public void setPoster(String poster) {
        this.poster = poster;
    }

    /**
     *
     * @return
     * The description
     */
    public List<String> getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(List<String> description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The role
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @param role
     * The role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     *
     * @return
     * The overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     *
     * @param overview
     * The overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     *
     * @return
     * The bio
     */
    public Bio getBio() {
        return bio;
    }

    /**
     *
     * @param bio
     * The bio
     */
    public void setBio(Bio bio) {
        this.bio = bio;
    }

    /**
     *
     * @return
     * The abilities
     */
    public Abilities getAbilities() {
        return abilities;
    }

    /**
     *
     * @param abilities
     * The abilities
     */
    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

}
