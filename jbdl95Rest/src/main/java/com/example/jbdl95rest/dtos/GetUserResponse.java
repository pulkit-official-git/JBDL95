package com.example.jbdl95rest.dtos;

import com.example.jbdl95rest.model.Gender;
import com.example.jbdl95rest.model.User;

public class GetUserResponse {


    private String name;
    private String email;
    private Integer age;
    private Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static GetUserResponse toModel(User user){
        if(user==null){
            return null;
        }
        GetUserResponse getUserResponse = new GetUserResponse();
        getUserResponse.setName(user.getName());
        getUserResponse.setAge(user.getAge());
        getUserResponse.setEmail(user.getEmail());
        getUserResponse.setGender(user.getGender());
        return getUserResponse;

    }
}
