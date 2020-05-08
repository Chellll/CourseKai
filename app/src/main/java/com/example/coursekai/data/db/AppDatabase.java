package com.example.coursekai.data.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.coursekai.AppExecutors;
import com.example.coursekai.data.db.dao.AuthorDao;
import com.example.coursekai.data.db.dao.CategoryDao;
import com.example.coursekai.data.db.dao.CourseDao;
import com.example.coursekai.data.db.dao.SubCategoryDao;
import com.example.coursekai.data.db.dao.UserDao;
import com.example.coursekai.data.db.dataGenerator.AuthorGenerator;
import com.example.coursekai.data.db.dataGenerator.CategoryGenerator;
import com.example.coursekai.data.db.dataGenerator.CourseGenerator;
import com.example.coursekai.data.db.dataGenerator.SubCategoryGenerator;
import com.example.coursekai.data.db.dataGenerator.UserGenerator;
import com.example.coursekai.data.db.entity.AuthorEntity;
import com.example.coursekai.data.db.entity.CategoryEntity;
import com.example.coursekai.data.db.entity.CourseEntity;
import com.example.coursekai.data.db.entity.SubCategoryEntity;
import com.example.coursekai.data.db.entity.UserEntity;
import com.example.coursekai.data.model.Author;

@Database(entities = {UserEntity.class, CourseEntity.class, SubCategoryEntity.class, CategoryEntity.class, AuthorEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    private static AppDatabase sInstance;

    public static final String DATABASE_NAME = "exampleee";

    public abstract UserDao userDao();
    public abstract CourseDao courseDao();
    public abstract CategoryDao categoryDao();
    public abstract SubCategoryDao subCategoryDao();
    public abstract AuthorDao authorDao();

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();


    public static AppDatabase getInstance(final Context context, final AppExecutors executors) {

        if(sInstance == null){
            synchronized (AppDatabase.class){
                if(sInstance == null){
                    sInstance = buildDatabase(context.getApplicationContext(), executors);
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private static AppDatabase buildDatabase(final Context appContext, final AppExecutors executors){
        return Room.databaseBuilder(appContext, AppDatabase.class, DATABASE_NAME)
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);

                        executors.getmDiskIO().execute(() ->{

                            AppDatabase database = AppDatabase.getInstance(appContext, executors);

                            for(UserEntity author : UserGenerator.generateUsers()){
                                database.userDao().insertOne(author);
                            }

                            for(CategoryEntity categoryEntity : CategoryGenerator.generateCourses()){
                                database.categoryDao().insertOne(categoryEntity);
                            }

                            for(SubCategoryEntity subCategoryEntity : SubCategoryGenerator.generateSubCategory()){
                                database.subCategoryDao().insertOne(subCategoryEntity);
                            }

                            for(CourseEntity courseEntity : CourseGenerator.generateCourse()){
                                database.courseDao().insertOne(courseEntity);
                            }

                            for(AuthorEntity authorEntity : AuthorGenerator.generateAuthor()){
                                database.authorDao().insertOne(authorEntity);
                            }

                            database.setDatabaseCreated();
                        });
                    }
                })
                //.addMigrations(MIGRATION_2_3)
                .build();
    }

    private void updateDatabaseCreated(final Context context){
        if(context.getDatabasePath(DATABASE_NAME).exists()){
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }

    public LiveData<Boolean> getDatabaseCreated(){
        mIsDatabaseCreated.setValue(true);
        return mIsDatabaseCreated;
    }

    private static final Migration MIGRATION_2_3 = new Migration(2,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //TODO: Почитать про миграцию ROOM
        }
    };

}
