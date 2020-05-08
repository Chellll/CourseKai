package com.example.coursekai.data.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.coursekai.data.model.Author;

import java.time.LocalDate;
import java.util.Date;

@Entity(tableName = "author")
public class AuthorEntity implements Author {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String icon;
    private String description;
    private String createdDate;

    public AuthorEntity(){

    }

    public AuthorEntity(String name, String icon, String description, String createdDate) {
        this.name = name;
        this.icon = icon;
        this.description = description;
        this.createdDate = createdDate;
    }

    public AuthorEntity(Author author){
        this.id = author.getId();
        this.name = author.getName();
        this.icon = author.getIcon();
        this.description = author.getDescription();
        this.createdDate = author.getCreatedDate();
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
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
