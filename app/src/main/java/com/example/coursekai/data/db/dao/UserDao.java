package com.example.coursekai.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.coursekai.data.db.entity.UserEntity;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    LiveData<List<UserEntity>> loadAllUser();

    @Query("SELECT * FROM user WHERE id = :userId")
    LiveData<UserEntity> loadUser(long userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<UserEntity> users);

    @Insert
    long insertOne(UserEntity user);

}
