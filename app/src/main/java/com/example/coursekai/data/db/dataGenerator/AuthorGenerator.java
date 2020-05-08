package com.example.coursekai.data.db.dataGenerator;

import androidx.room.Entity;

import com.example.coursekai.data.db.entity.AuthorEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuthorGenerator {

    private static final String[] name = new String[]{
            "Олиг Митрофанов",
            "Apple",
            "Samsung",
            "Sberbank"
    };

    private static final String[] description = new String[]{
            "Я тот то тот то, занимаюсь этим и рад предоставить вам новые данные"
    };

    public static List<AuthorEntity> generateAuthor(){
        List<AuthorEntity> authors = new ArrayList<>();

        for(int i = 0; i < name.length; i++){
            AuthorEntity authorEntity = new AuthorEntity();

            authorEntity.setName(name[i]);
            authorEntity.setCreatedDate(new Date().toString());
            authorEntity.setDescription(description[0]);
            authorEntity.setIcon("icon");

            authors.add(authorEntity);
        }
        return authors;
    }

}
