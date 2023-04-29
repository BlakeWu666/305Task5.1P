package com.example.a305task51p;

public class detailModel {
    static String name;
    static String description;

    public detailModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static String getName() {
        return name;
    }

    public static String getDescription() {
        return description;
    }
}
