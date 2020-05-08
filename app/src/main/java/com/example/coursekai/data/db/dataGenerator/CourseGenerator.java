package com.example.coursekai.data.db.dataGenerator;

import com.example.coursekai.data.db.entity.CourseEntity;

import java.util.ArrayList;
import java.util.List;

public class CourseGenerator {

    private static final String[] Name = new String[]{
            "Старт в Android - разработку",
            "Программирование на Python",
            "Алгоритмы: теория и практика. Методы",
            "Введение в программирование (C++)",
            "Основы статистики"
    };
    private static final String[] Description = new String[]{
            "На этом курсе мы будем учиться разрабатывать приложения под платформу Android",
            "Курс посвящен базовым понятиям и элементам языка программирования Python (операторы, числовые и строковые переменные, списки, условия и циклы). Курс является вводным и наиболее подойдет слушателям, не имеющим опыта написания программ ни на одном из языков программирования.",
            "В курсе будут разобраны основные алгоритмические методы: жадные алгоритмы, «разделяй и властвуй», динамическое программирование. Помимо теоретических основ, будут рассмотрены тонкости реализации рассмотренных алгоритмов на языках C++, Java и Python.",
            "Основы программирования на C++ на примере множества несложных практических задач.",
            "Курс знакомит слушателей с основными понятиями и методами математической статистики. В течение трех недель мы рассмотрим наиболее широко используемые статистические методы и принципы, стоящие за ними. Полученных знаний будет достаточно для решения широкого круга задач, возникающих в рамках исследовательской работы."
    };
    private static final Double[] Raiting = new Double[]{
                3.2,
                4.5,
                2.5,
                4.0,
                1.2
    };
    private static final long[] IdCategory = new long[]{
            1,
            1,
            2,
            1,
            2
    };

    private static final long[] IdAuthor = new long[]{
            1,
            3,
            1,
            2,
            1
    };

    public static List<CourseEntity> generateCourse(){
        List<CourseEntity> courses = new ArrayList<>(Name.length);

        for(int i = 0; i < Name.length; i++){
            CourseEntity course = new CourseEntity();

            course.setName(Name[i]);
            course.setDescription(Description[i]);
            course.setRaiting(Raiting[i]);
            course.setIdCategory(IdCategory[i]);
            course.setIdAuthor(IdAuthor[i]);
            course.setIcon("icon");

            courses.add(course);
        }

        return courses;
    }

}
