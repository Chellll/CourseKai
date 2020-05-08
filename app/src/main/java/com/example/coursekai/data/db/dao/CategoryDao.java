package com.example.coursekai.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.coursekai.data.db.entity.CategoryEntity;

import java.util.List;

@Dao
public interface CategoryDao {

    @Query("select * from category")
    LiveData<List<CategoryEntity>> getAllCategory();

    @Query("select * from category where id = :categoryId")
    LiveData<CategoryEntity> getCategory(long categoryId);

    @Insert
    void insertOne(CategoryEntity categoryEntity);

}
