package com.example.jbdl95rest.dtos;

import com.example.jbdl95rest.model.Gender;
import com.example.jbdl95rest.model.User;

import java.util.Date;

public class UserCreateResponse {


    private Integer id;
    private Date createdOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public static UserCreateResponse ModelToDto(User user){
        UserCreateResponse userCreateResponse = new UserCreateResponse();
        userCreateResponse.setId(user.getId());
        userCreateResponse.setCreatedOn(user.getCreatedOn());
        return userCreateResponse;
    }
}
