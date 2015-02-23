package es.ffgiraldez.hmr.rest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;
/**
 * @author Fernando Franco Giráldez
 */
@Builder
@Getter
@Accessors(fluent = true)
@AllArgsConstructor
public class BookResponse {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    @SerializedName("ID")
    private String identifier;
    @SerializedName("title")
    private String title;
    @SerializedName("author")
    private String author;
    @SerializedName("publisher")
    private String publisher;
    @SerializedName("publisher_date")
    private String publishDate;
    @SerializedName("language")
    private String language;
    @SerializedName("url_read_online")
    private String urlDownload;
    @SerializedName("url_details")
    private String urlDetails;
    @SerializedName("cover")
    private String cover;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("content")
    private String description;
    @SerializedName("rating")
    private float rating;
    @SerializedName("pages")
    private int pages;
    @SerializedName("num_comments")
    private int comments;
    @SerializedName("tags")
    private List<TagResponse> tags;
    @SerializedName("categories")
    private List<CategoryResponse> categories;
}
