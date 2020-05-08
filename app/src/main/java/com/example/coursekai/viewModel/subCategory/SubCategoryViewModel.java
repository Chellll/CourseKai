package com.example.coursekai.viewModel.subCategory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.coursekai.BasicApp;
import com.example.coursekai.data.db.entity.SubCategoryEntity;

public class SubCategoryViewModel extends AndroidViewModel {

    private LiveData<SubCategoryEntity> mObservableSubCategory;


    public SubCategoryViewModel(@NonNull Application application, SubCategoryRepository repository, final long id) {
        super(application);

        mObservableSubCategory = repository.getSubCategory(id);

    }

    public LiveData<SubCategoryEntity> getmObservableSubCategory(){
        return mObservableSubCategory;
    }

    public static class SubCategoryFactory extends ViewModelProvider.NewInstanceFactory{

        @NonNull
        private final Application application;

        private final long mId;

        private final SubCategoryRepository mRepository;

        public SubCategoryFactory(@NonNull Application application, long mId) {
            this.application = application;
            this.mId = mId;
            this.mRepository = ((BasicApp)application).getSubCategoryRepository();
        }

        @SuppressWarnings("unchecked")
        @Override
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass){
            return (T) new SubCategoryViewModel(application, mRepository, mId);
        }
    }

}
