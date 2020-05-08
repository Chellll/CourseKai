package com.example.coursekai.viewModel.subCategory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.coursekai.data.db.AppDatabase;
import com.example.coursekai.data.db.entity.SubCategoryEntity;
import com.example.coursekai.data.model.SubCategory;

import java.util.List;

public class SubCategoryRepository {

    private static SubCategoryRepository sInstance;

    private final AppDatabase mDatabase;
    private MediatorLiveData<List<SubCategoryEntity>> mObservableSubCategory;

    private SubCategoryRepository(final AppDatabase database){
        mDatabase = database;
        mObservableSubCategory = new MediatorLiveData<>();

        mObservableSubCategory.addSource(mDatabase.subCategoryDao().getAllSubCategory(),
                subCategoryEntities -> {
                    if(mDatabase.getDatabaseCreated().getValue() != null){
                        mObservableSubCategory.postValue(subCategoryEntities);
                    }
                });
    }

    public static SubCategoryRepository getsInstance(final AppDatabase database) {
        if(sInstance == null){
            synchronized (SubCategoryRepository.class){
                if(sInstance == null){
                    sInstance = new SubCategoryRepository(database);
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<SubCategoryEntity>> getAllSubCategory(){
        return mDatabase.subCategoryDao().getAllSubCategory();
    }

    public LiveData<SubCategoryEntity> getSubCategory(final long subCategoryId){
        return mDatabase.subCategoryDao().getSubCategory(subCategoryId);
    }
}
