package com.example.coursekai.viewModel.author;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.coursekai.data.db.AppDatabase;
import com.example.coursekai.data.db.entity.AuthorEntity;

import java.time.chrono.MinguoDate;
import java.util.List;

public class AuthorRepository {

    private static AuthorRepository sInstance;
    private final AppDatabase mDatabase;
    private MediatorLiveData<List<AuthorEntity>> mObservableAuthor;

    private AuthorRepository(final AppDatabase database){
        mDatabase = database;
        mObservableAuthor = new MediatorLiveData<>();

        mObservableAuthor.addSource(mDatabase.authorDao().getAllAuthor(),
                authorEntities -> {
            if(mDatabase.getDatabaseCreated().getValue() != null){
                mObservableAuthor.postValue(authorEntities);
            }
                } );
    }

    public static AuthorRepository getInstance(final AppDatabase database){
        if(sInstance == null){
            synchronized (AuthorRepository.class){
                if(sInstance == null){
                    sInstance = new AuthorRepository(database);
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<AuthorEntity>> getAllAuthor(){
        return mDatabase.authorDao().getAllAuthor();
    }

    public LiveData<List<AuthorEntity>> getAllAuthorWithName(){
        return mDatabase.authorDao().getAllAuthorWithName();
    }

    public LiveData<List<AuthorEntity>> getallAuthorWithDate(){
        return mDatabase.authorDao().getAllAuthorWithDate();
    }

    public LiveData<AuthorEntity> getAuthor(final long authorId){
        return mDatabase.authorDao().getAuthor(authorId);
    }

    public void insertOne(AuthorEntity author){
        new Thread(new Runnable() {
            @Override
            public void run() {
                mDatabase.authorDao().insertOne(author);
            }
        });
    }

}
