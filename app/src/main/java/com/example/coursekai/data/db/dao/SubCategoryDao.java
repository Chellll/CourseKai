package com.example.coursekai.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.coursekai.data.db.entity.CategoryEntity;
import com.example.coursekai.data.db.entity.SubCategoryEntity;
import com.example.coursekai.data.model.SubCategory;

import java.util.List;

@Dao
public interface SubCategoryDao {

    @Query("select * from subcategory")
    LiveData<List<SubCategoryEntity>> getAllSubCategory();

    @Query("select * from subCategory where id = :subCategoryId")
    LiveData<SubCategoryEntity> getSubCategory(long subCategoryId);

    @Insert
    void insertOne(SubCategoryEntity categoryEntity);

}
