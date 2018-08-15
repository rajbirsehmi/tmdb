package com.creative.tmdb.jsonmapping.moviedetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonMovieDetail {

    @SerializedName("adult")
    @Expose
    private boolean isAdult;

    @SerializedName("backdrop_path")
    @Expose
    private String widePosterPath;

    @SerializedName("belongs_to_collection")
    @Expose
    private JsonMovieCollectionGroup collectionGroup;

    @SerializedName("budget")
    @Expose
    private long budget;

    @SerializedName("genres")
    @Expose
    private JsonMovieGenre[] jsonMovieGenres;

    @SerializedName("homepage")
    @Expose
    private String homepage;

    @SerializedName("id")
    @Expose
    private int movieId;

    @SerializedName("imdb_id")
    @Expose
    private String imdbId;

    @SerializedName("original_language")
    @Expose
    private String originalLanguage;

    @SerializedName("original_title")
    @Expose
    private String originalTitle;

    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("popularity")
    @Expose
    private float popularity;

    @SerializedName("poster_path")
    @Expose
    private String portraitPosterPath;

    @SerializedName("production_companies")
    @Expose
    private JsonMovieProductionCompany[] productionCompanies;

    @SerializedName("production_countries")
    @Expose
    private JsonMovieProductionCountry[] productionCountries;

    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    @SerializedName("revenue")
    @Expose
    private long revenue;

    @SerializedName("runtime")
    @Expose
    private int runtime;

    @SerializedName("spoken_languages")
    @Expose
    private JsonMovieSpokenLanguage[] spokenLanguages;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("tagline")
    @Expose
    private String tagline;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("video")
    @Expose
    private boolean isVideo;

    @SerializedName("vote_average")
    @Expose
    private float voteAverage;

    @SerializedName("vote_count")
    @Expose
    private int voteCount;

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public String getWidePosterPath() {
        return widePosterPath;
    }

    public void setWidePosterPath(String widePosterPath) {
        this.widePosterPath = widePosterPath;
    }

    public JsonMovieCollectionGroup getCollectionGroup() {
        return collectionGroup;
    }

    public void setCollectionGroup(JsonMovieCollectionGroup collectionGroup) {
        this.collectionGroup = collectionGroup;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public JsonMovieGenre[] getJsonMovieGenres() {
        return jsonMovieGenres;
    }

    public void setJsonMovieGenres(JsonMovieGenre[] jsonMovieGenres) {
        this.jsonMovieGenres = jsonMovieGenres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getPortraitPosterPath() {
        return portraitPosterPath;
    }

    public void setPortraitPosterPath(String portraitPosterPath) {
        this.portraitPosterPath = portraitPosterPath;
    }

    public JsonMovieProductionCompany[] getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(JsonMovieProductionCompany[] productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public JsonMovieProductionCountry[] getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(JsonMovieProductionCountry[] productionCountries) {
        this.productionCountries = productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public JsonMovieSpokenLanguage[] getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(JsonMovieSpokenLanguage[] spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
