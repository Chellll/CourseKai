package com.example.coursekai.viewModel.author;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

import com.example.coursekai.BasicApp;
import com.example.coursekai.data.db.entity.AuthorEntity;

import java.util.List;

public class AuthorListViewModel extends AndroidViewModel {

    private final SavedStateHandle savedStateHandle;
    private final AuthorRepository repository;
    private final LiveData<List<AuthorEntity>> authors;

    public AuthorListViewModel(@NonNull Application application, SavedStateHandle savedStateHandle){
        super(application);

        this.savedStateHandle = savedStateHandle;

        repository = ((BasicApp)application).getAuthorrepository();

        authors = repository.getAllAuthor();
    }

    public LiveData<List<AuthorEntity>> getAllAuthors(){
        return repository.getAllAuthor();
    }

    public LiveData<List<AuthorEntity>> getAllAuthorWithName(){
        return repository.getAllAuthorWithName();
    }

    public LiveData<List<AuthorEntity>> getAllAuthorWithDate(){
        return repository.getallAuthorWithDate();
    }

    public LiveData<AuthorEntity> insertOne(final long authorId){
        return repository.getAuthor(authorId);
    }

    public void insertOne(AuthorEntity author){
        new Thread(new Runnable() {
            @Override
            public void run() {
                repository.insertOne(author);
            }
        });
    }

}
