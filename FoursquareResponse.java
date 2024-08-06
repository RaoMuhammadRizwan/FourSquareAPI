package com.example.square;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoursquareResponse {
    @SerializedName("results")
    private List<Place> results;

    // Getters and setters
    public List<Place> getResults() {
        return results;
    }

    public void setResults(List<Place> results) {
        this.results = results;
    }

}
