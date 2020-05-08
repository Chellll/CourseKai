package com.example.coursekai.viewModel.course;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.coursekai.data.db.AppDatabase;
import com.example.coursekai.data.db.entity.CourseEntity;
import com.example.coursekai.data.model.Course;

import java.util.List;

public class CourseRepository {

    private static CourseRepository sInstance;
    private final AppDatabase mDatabase;
    private MediatorLiveData<List<CourseEntity>> mObservableCourse;

    private CourseRepository(final AppDatabase database){
        mDatabase = database;
        mObservableCourse = new MediatorLiveData<>();

        mObservableCourse.addSource(mDatabase.courseDao().getAllCourses(),
                courseEntities -> {
                    if(mDatabase.getDatabaseCreated().getValue() != null){
                        mObservableCourse.postValue(courseEntities);
            }
        });
    }

    public static CourseRepository getInstance(final AppDatabase database){
        if(sInstance == null){
            synchronized (CourseRepository.class){
                if(sInstance == null){
                    sInstance = new CourseRepository(database);
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<CourseEntity>> getAllCourse(){
        return mDatabase.courseDao().getAllCourses();
    }

    public LiveData<List<CourseEntity>> getAllCourseWithRaiting(){
        return mDatabase.courseDao().getAllCourseWithRaiting();
    }

    public LiveData<List<CourseEntity>> getAllCourseWithAuthor(final  long authorId){
        return mDatabase.courseDao().getAllCoursesWithAuthor(authorId);
    }

    public LiveData<List<CourseEntity>> getAllCourseWithCategory(final long categoryId){
        return mDatabase.courseDao().getAllCoursesWithCategory(categoryId);
    }

    public LiveData<CourseEntity> getCourse(final long courseId){
        return mDatabase.courseDao().getCourse(courseId);
    }

    public void insertOne(CourseEntity course){
        mDatabase.courseDao().insertOne(course);
    }

}
