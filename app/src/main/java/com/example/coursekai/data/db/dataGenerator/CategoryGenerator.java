package com.example.coursekai.data.db.dataGenerator;

import com.example.coursekai.data.db.entity.CategoryEntity;

import java.util.ArrayList;
import java.util.List;

public class CategoryGenerator {

    private static final String name[] = new String[]{
            "Программирование",
            "Современная грамотность",
            "Естественные науки",
            "Гуманитарные науки"
    };

    public static List<CategoryEntity> generateCourses(){

        List<CategoryEntity> categoryEntities = new ArrayList<>();

        for(int i = 0; i < name.length; i++){
            CategoryEntity categoryEntity = new CategoryEntity();

            categoryEntity.setName(name[i]);

            categoryEntities.add(categoryEntity);
        }

        return categoryEntities;
    }

}
