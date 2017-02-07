package com.vjam.demo.model;

/**
 * Created by anand.chandaliya on 07-02-2017.
 */

public class ItemModel {
    String name;
    String price;
    String details;
    String code;
    String id;
    String color;
    String catogery;
    String thumbnailUrl;
    int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    int localThumbnail;

    public ItemModel(String name, int cost, int cover) {
        this.name = name;
        this.cost = cost;
        localThumbnail = cover;
    }

    public int getLocalThumbnail() {
        return localThumbnail;
    }

    public void setLocalThumbnail(int localThumbnail) {
        this.localThumbnail = localThumbnail;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCatogery() {
        return catogery;
    }

    public void setCatogery(String catogery) {
        this.catogery = catogery;
    }
}
