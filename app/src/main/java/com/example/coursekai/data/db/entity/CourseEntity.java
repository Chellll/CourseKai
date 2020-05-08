package com.example.coursekai.data.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.coursekai.data.model.Course;

@Entity(tableName = "course")
public class CourseEntity implements Course {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String description;
    private Double raiting;
    private long idCategory;
    private String icon;
    private long idAuthor;

    public CourseEntity(){

    }

    public CourseEntity(String name, String description, Double raiting, long idCategory, String icon, long idAuthor) {
        this.name = name;
        this.description = description;
        this.raiting = raiting;
        this.idCategory = idCategory;
        this.icon = icon;
        this.idAuthor = idAuthor;
    }

    public CourseEntity(Course course){
        this.id = course.getId();
        this.name = course.getName();
        this.description = course.getDescription();
        this.raiting = course.getRaiting();
        this.idCategory = course.getIdCategory();
        this.icon = course.getIcon();
        this.idAuthor = course.getIdAuthor();
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Double getRaiting() {
        return raiting;
    }

    public void setRaiting(Double raiting) {
        this.raiting = raiting;
    }

    @Override
    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(long idAuthor) {
        this.idAuthor = idAuthor;
    }
}
