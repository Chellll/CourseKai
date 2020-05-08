package com.example.coursekai.data.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.coursekai.data.model.SubCategory;

@Entity(tableName = "subCategory")
public class SubCategoryEntity implements SubCategory {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String description;
    private long idCategory;

    public SubCategoryEntity(){}

    public SubCategoryEntity(String name, String description, long idCategory) {
        this.name = name;
        this.description = description;
        this.idCategory = idCategory;
    }

    @Override
    public Long getId() {
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

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }
}
