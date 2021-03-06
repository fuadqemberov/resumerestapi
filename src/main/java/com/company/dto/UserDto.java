package com.company.dto;

import com.company.Entity.User;

public class UserDto {

    private int id;
    private String name;
    private String surname;
 private String password;


    public UserDto(int id, String name, String surname, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public UserDto(User u ){

        this.id = u.getId();
        this.name = u.getName();
        this.surname = u.getSurname();

    }


    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
