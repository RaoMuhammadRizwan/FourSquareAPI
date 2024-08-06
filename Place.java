package com.example.square;

import com.google.gson.annotations.SerializedName;

public class Place {
    @SerializedName("name")
    private String name;

    @SerializedName("location")
    private Location location;

    @SerializedName("rating")
    private double rating;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public static class Location {
        @SerializedName("address")
        private String address;

        // Getters and setters
        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
