package com.example.coursekai.data.db.dataGenerator;

import com.example.coursekai.data.db.entity.SubCategoryEntity;
import com.example.coursekai.data.model.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryGenerator {

    private static final String[] name1 = new String[]{
            "Android - разработка",
            "Алгоритмы и структуры данных"
    };

    private static final String[] name2 = new String[]{
            "Пдд",
            "Вводный курс по правам человека",
            "Теория аргументации"
    };

    private static final String[] name3 = new String[]{
            "Молекулярная биология и генетика",
            "ИНженерия будущего"
    };

    private static final String[] name4 = new String[]{
            "Философия",
            "Научное мышление",
            "Обществознание"
    };

    private static final String[] description1 = new String[]{
            "В этом курсе вы научитесь разрабатывать приложения под платформу Android",
            "В курсе подробно разобраны базовые алгоритмические методы: \nЖадные алгоритмы \nМетод Разделяй и властвуй\nИ прочие"
    };

    private static final String[] description2 = new String[]{
            "Онлайн тренажер, помогающий легко и быстро подготовиться к сдаче теоретического экзамена в ГАИ",
            "Опытные правозащитники, активисты, просветители и мультипликаторы помогут вам разобраться в различных вопросах, касающихся прав человека",
            "Курс затрагивает основные подходы к анализу аргументации"
    };

    private static final String[] description3 = new String[]{
            "Вы познакомитесь с основными понятиями молекулярной биологии и генетики",
            "Даннык курс познакомит вас с четырьмя различными направлениями современной инженерии"
    };

    private static final String[] description4 = new String[]{
            "Курс освещает основные разделы философии",
            "Кратко о научном и рацональном мышлении",
            "Курс расчитан на абитуриентов, которые хотят подготовиться к сдаче экзаменов"
    };

    public static List<SubCategoryEntity> generateSubCategory(){

        List<SubCategoryEntity> subCategoryEntities = new ArrayList<>();

        for(int i = 0; i < name1.length; i++){
            SubCategoryEntity entity = new SubCategoryEntity();

            entity.setName(name1[i]);
            entity.setDescription(description1[i]);
            entity.setIdCategory(1);

            subCategoryEntities.add(entity);
        }

        for(int i = 0; i < name2.length; i++){
            SubCategoryEntity entity = new SubCategoryEntity();

            entity.setName(name2[i]);
            entity.setDescription(description2[i]);
            entity.setIdCategory(2);

            subCategoryEntities.add(entity);
        }

        for(int i = 0; i < name3.length; i++){
            SubCategoryEntity entity = new SubCategoryEntity();

            entity.setName(name3[i]);
            entity.setDescription(description3[i]);
            entity.setIdCategory(3);

            subCategoryEntities.add(entity);
        }

        for(int i = 0; i < name4.length; i++){
            SubCategoryEntity entity = new SubCategoryEntity();

            entity.setName(name4[i]);
            entity.setDescription(description4[i]);
            entity.setIdCategory(4);

            subCategoryEntities.add(entity);
        }

        return subCategoryEntities;
    }

}
