package com.example.coursekai.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.coursekai.data.db.entity.CategoryEntity;
import com.example.coursekai.data.db.entity.CourseEntity;
import com.example.coursekai.data.db.entity.CourseFull;

import java.util.List;

@Dao
public interface CourseDao {

    @Query("select * from course")
    LiveData<List<CourseEntity>> getAllCourses();

    @Query("select * from course order by raiting")
    LiveData<List<CourseEntity>> getAllCourseWithRaiting();

    @Query("select * from course where idAuthor = :authorId")
    LiveData<List<CourseEntity>> getAllCoursesWithAuthor(long authorId);

    @Query("select * from course where idCategory = :categoryId")
    LiveData<List<CourseEntity>> getAllCoursesWithCategory(long categoryId);

    @Query("select * from course where id = :courseId")
    LiveData<CourseEntity> getCourse(long courseId);

    @Query("select course.id, course.name, course.description, course.raiting, category.name, course.icon, author.name " +
            "from course, author, category " +
            "where course.id = :courseId and " +
            "course.idAuthor == author.id and course.idCategory == category.id")
    LiveData<CourseFull> getFullCourse(long courseId);

    @Insert
    void insertOne(CourseEntity categoryEntity);
}
