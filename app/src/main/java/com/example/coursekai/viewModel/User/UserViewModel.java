package com.example.coursekai.viewModel.User;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.coursekai.BasicApp;
import com.example.coursekai.data.db.entity.UserEntity;

public class UserViewModel extends AndroidViewModel {

    private LiveData<UserEntity> mObservableUser;

    public UserViewModel(@NonNull Application application, UserRepository userRepository, final long userId) {
        super(application);

        mObservableUser = userRepository.getUser(userId);
    }

    public LiveData<UserEntity> getmObservableUser(){
        return mObservableUser;
    }

    public static class UserFactory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application mApplication;

        private final long mUserId;

        private final UserRepository mRepository;

        public UserFactory(@NonNull Application mApplication, long mUserId) {
            this.mApplication = mApplication;
            this.mUserId = mUserId;
            this.mRepository = ((BasicApp) mApplication).getUserRepository();
        }

        @SuppressWarnings("unchecked")
        @Override
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass){
            return (T) new UserViewModel(mApplication, mRepository, mUserId);
        }

    }


}
