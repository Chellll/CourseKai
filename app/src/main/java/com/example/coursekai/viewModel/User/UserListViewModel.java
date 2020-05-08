package com.example.coursekai.viewModel.User;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.example.coursekai.BasicApp;
import com.example.coursekai.data.db.entity.UserEntity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Action;

public class UserListViewModel extends AndroidViewModel {

    private final SavedStateHandle savedStateHandle;
    private final UserRepository mRepository;
    private final LiveData<List<UserEntity>> mUsers;
    private MutableLiveData<Long> userInsertId = new MutableLiveData<>();

    public UserListViewModel(@NonNull Application application, SavedStateHandle savedStateHandle) {
        super(application);

        this.savedStateHandle = savedStateHandle;

        mRepository = ((BasicApp) application).getUserRepository();

        mUsers = mRepository.getAllUser();
    }

    long k;

    public long insertUser(UserEntity user){

        new Thread(new Runnable() {
            public void run() {
                k = mRepository.insertUser(user);
                userInsertId.postValue(k);

            }
        }).start();
        return k;

//
//       long k = mRepository.insertUser(user);
//       userInsertId.postValue(k);
    }

    public LiveData<Long> getDbInsertedId(){
        return userInsertId;
    }

    public LiveData<List<UserEntity>> getmUsers() {
        return mUsers;
    }

}
