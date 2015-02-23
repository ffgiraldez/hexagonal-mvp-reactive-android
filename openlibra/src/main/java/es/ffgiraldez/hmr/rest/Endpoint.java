package es.ffgiraldez.hmr.rest;

import java.util.List;

import retrofit.http.GET;

/**
 * @author Fernando Franco Giráldez
 */
public interface Endpoint {
    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    @GET("/get/?num_items=30&criteria=last_week&decode=true")
    List<BookResponse> recent();
}
