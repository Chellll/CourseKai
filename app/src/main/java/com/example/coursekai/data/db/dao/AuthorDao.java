package com.example.coursekai.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.coursekai.data.db.entity.AuthorEntity;

import java.util.List;

@Dao
public interface AuthorDao {

    @Query("select * from author")
    LiveData<List<AuthorEntity>> getAllAuthor();

    @Query("select * from author order by createdDate")
    LiveData<List<AuthorEntity>> getAllAuthorWithDate();

    @Query("select * from author order by name")
    LiveData<List<AuthorEntity>> getAllAuthorWithName();

    @Query("select * from author where id = :authorId")
    LiveData<AuthorEntity> getAuthor(final long authorId);

    @Insert
    void insertOne(AuthorEntity author);
}
