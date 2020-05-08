package com.example.coursekai.viewModel.User;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.coursekai.data.db.AppDatabase;
import com.example.coursekai.data.db.entity.UserEntity;

import java.util.List;

public class UserRepository {

    private static UserRepository sInstance;

    private final AppDatabase mDatabase;
    private MediatorLiveData<List<UserEntity>> mObservableUsers;

    private UserRepository(final AppDatabase database) {
        mDatabase = database;
        mObservableUsers = new MediatorLiveData<>();

        mObservableUsers.addSource(mDatabase.userDao().loadAllUser(),
                userEntities -> {
                    if (mDatabase.getDatabaseCreated().getValue() != null) {
                        mObservableUsers.postValue(userEntities);
                    }
                });
    }

    public static UserRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (UserRepository.class) {
                if (sInstance == null) {
                    sInstance = new UserRepository(database);
                }
            }
        }
        return sInstance;
    }

    public long insertUser(UserEntity user){
        return mDatabase.userDao().insertOne(user);
    }

    public LiveData<List<UserEntity>> getAllUser() {
        return mObservableUsers;
    }

    public LiveData<UserEntity> getUser(final long userId) {
        return mDatabase.userDao().loadUser(userId);
    }

}
