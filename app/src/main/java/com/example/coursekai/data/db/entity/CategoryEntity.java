package com.example.coursekai.data.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.coursekai.data.model.Category;

@Entity(tableName = "category")
public class CategoryEntity implements Category {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;

    public CategoryEntity(){

    }

    public CategoryEntity(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
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
}
