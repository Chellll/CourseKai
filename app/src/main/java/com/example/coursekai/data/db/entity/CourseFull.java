package com.example.coursekai.data.db.entity;

public class CourseFull {

    private long id;
    private String name;
    private String description;
    private Double raiting;
    private String nameCategory;
    private String icon;
    private String nameAuthor;

    public CourseFull(){

    }

    public CourseFull(long id, String name, String description, Double raiting, String nameCategory, String icon, String nameAuthor) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.raiting = raiting;
        this.nameCategory = nameCategory;
        this.icon = icon;
        this.nameAuthor = nameAuthor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRaiting() {
        return raiting;
    }

    public void setRaiting(Double raiting) {
        this.raiting = raiting;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }
}
