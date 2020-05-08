package com.example.coursekai.data.db.entity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.coursekai.data.model.User;

@Entity(tableName = "user")
public class UserEntity extends BaseObservable implements User{

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String location;
    private String createdDate;
    private String phone;

    public UserEntity(){}

    public UserEntity(int id, String name, String surname, String email, String password, String location, String createdDate, String phone ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.location = location;
        this.createdDate = createdDate;
        this.phone = phone;
    }

    public UserEntity(String name, String surname, String email, String password, String location, String createdDate, String phone ) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.location = location;
        this.createdDate = createdDate;
        this.phone = phone;
    }

    public UserEntity(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.location = user.getLocation();
        this.createdDate = user.getCreatedDate();
        this.phone = user.getPhone();
    }

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Bindable
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
