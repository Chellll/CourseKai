package com.example.coursekai.viewModel.subCategory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

import com.example.coursekai.BasicApp;
import com.example.coursekai.data.db.entity.SubCategoryEntity;

import java.util.List;

public class SubCategoryListViewModel extends AndroidViewModel {

    private final SavedStateHandle savedStateHandle;
    private final SubCategoryRepository repository;
    private final LiveData<List<SubCategoryEntity>> subCategoryEntity;

    public SubCategoryListViewModel(@NonNull Application application, SavedStateHandle savedStateHandle){
        super(application);

        this.savedStateHandle = savedStateHandle;

        repository = ((BasicApp)application).getSubCategoryRepository();

        subCategoryEntity = repository.getAllSubCategory();
    }

    public LiveData<List<SubCategoryEntity>> getSubCategoryEntity(){
        return subCategoryEntity;
    }

}
