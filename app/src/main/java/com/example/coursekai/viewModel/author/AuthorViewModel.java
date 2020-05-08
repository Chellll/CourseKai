package com.example.coursekai.viewModel.author;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.coursekai.BasicApp;
import com.example.coursekai.data.db.entity.AuthorEntity;
import com.example.coursekai.viewModel.course.CourseRepository;
import com.example.coursekai.viewModel.course.CourseViewModel;

public class AuthorViewModel extends AndroidViewModel {

    private LiveData<AuthorEntity> author;

    public AuthorViewModel(@NonNull Application application, AuthorRepository repository, final long id){
        super(application);

        author = repository.getAuthor(id);
    }

    public LiveData<AuthorEntity> getAuthor(){
        return author;
    }

    public static class AuthorFactory extends ViewModelProvider.NewInstanceFactory{

        @NonNull
        private final Application application;
        private final long courseId;
        private final AuthorRepository repository;

        public AuthorFactory(@NonNull Application application, long courseId){
            this.application = application;
            this.courseId = courseId;
            this.repository = ((BasicApp)application).getAuthorrepository();
        }

        @SuppressWarnings("unchecked")
        @Override
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass){
            return (T) new AuthorViewModel(application, repository, courseId);
        }
    }

}
