package com.example.coursekai.data.db.dataGenerator;

import com.example.coursekai.data.db.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserGenerator {

    private static final String[] Name = new String[]{
            "Special edition", "New", "Cheap", "Quality", "Used"};
    private static final String[] Surname = new String[]{
            "Three-headed Monkey", "Rubber Chicken", "Pint of Grog", "Monocle", "Kukuxa"};
    private static final String[] Email = new String[]{
            "is finally here", "is recommended by Stan S. Stanman",
            "is the best sold product on Mêlée Island", "is fgh️", "is fine"};
    private static final String[] Password = new String[]{
            "Comment 1", "Comment 2", "Comment 3", "Comment 4", "Comment 5"};

    public static List<UserEntity> generateUsers(){
        List<UserEntity> users = new ArrayList<>(Name.length);

        for(int i = 0; i < Name.length; i++){
            UserEntity user = new UserEntity();

            //user.setId(i);
            user.setName(Name[i]);
            user.setSurname(Surname[i]);
            user.setEmail(Email[i]);
            user.setPassword(Password[i]);
            user.setLocation("Location " + i);
            user.setCreatedDate(String.valueOf(System.currentTimeMillis()));

            users.add(user);
        }
        return users;
    }

}
