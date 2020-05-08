package com.example.coursekai;

import android.app.Application;

import com.example.coursekai.data.db.AppDatabase;
import com.example.coursekai.viewModel.User.UserRepository;
import com.example.coursekai.viewModel.author.AuthorRepository;
import com.example.coursekai.viewModel.course.CourseRepository;
import com.example.coursekai.viewModel.subCategory.SubCategoryRepository;

public class BasicApp extends Application {

    private AppExecutors mAppExecutors;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase(){
        return AppDatabase.getInstance(this, mAppExecutors);
    }

//    public AuthorRepository getAuthorRepository(){
//        return AuthorRepository.getInstance(getDatabase());
//    }
//
    public UserRepository getUserRepository(){
        return UserRepository.getInstance(getDatabase());
    }
//
//    public DataRepository getRepository(){
//        return DataRepository.getInstance(getDatabase());
//

    public SubCategoryRepository getSubCategoryRepository(){
        return SubCategoryRepository.getsInstance(getDatabase());
    }

    public CourseRepository getCourseRepository(){
        return CourseRepository.getInstance(getDatabase());
    }

    public AuthorRepository getAuthorrepository(){
        return AuthorRepository.getInstance(getDatabase());
    }

}
