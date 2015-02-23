package es.ffgiraldez.hmr.rest;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.experimental.Accessors;
/**
 * @author Fernando Franco Giráldez
 */
@Getter
@Accessors(fluent = true)
class CategoryResponse {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    @SerializedName("category_id")
    private String identifier;
    @SerializedName("name")
    private String name;
    @SerializedName("nicename")
    private String prettyName;
}
