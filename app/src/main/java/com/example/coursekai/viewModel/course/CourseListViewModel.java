package com.example.coursekai.viewModel.course;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

import com.example.coursekai.BasicApp;
import com.example.coursekai.data.db.entity.CourseEntity;

import java.util.List;

public class CourseListViewModel extends AndroidViewModel {

    private final SavedStateHandle savedStateHandle;
    private final CourseRepository mRepository;
    private final LiveData<List<CourseEntity>> courses;

    public CourseListViewModel(@NonNull Application application, SavedStateHandle savedStateHandle){
        super(application);

        this.savedStateHandle = savedStateHandle;

        mRepository = ((BasicApp)application).getCourseRepository();

        courses = mRepository.getAllCourse();
    }

    public LiveData<List<CourseEntity>> getAllCourse(){
        return mRepository.getAllCourse();
    }

    public LiveData<List<CourseEntity>> getAllCourseWithRaiting(){
        return mRepository.getAllCourseWithRaiting();
    }

    public LiveData<List<CourseEntity>> getAllCourseWithCategory(final long categoryId){
        return mRepository.getAllCourseWithCategory(categoryId);
    }

    public LiveData<List<CourseEntity>> getAllCourseWithAuthor(final long authorId){
        return mRepository.getAllCourseWithAuthor(authorId);
    }

    public void isnsertOne(CourseEntity courseEntity){
        mRepository.insertOne(courseEntity);
    }

}
