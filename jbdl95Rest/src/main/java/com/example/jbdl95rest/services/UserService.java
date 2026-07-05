package com.example.jbdl95rest.services;

import com.example.jbdl95rest.dtos.CreateUserRequest;
import com.example.jbdl95rest.dtos.GetUserResponse;
import com.example.jbdl95rest.dtos.UserCreateResponse;
import com.example.jbdl95rest.exception.UserNotFoundException;
import com.example.jbdl95rest.model.Status;
import com.example.jbdl95rest.model.User;
import com.example.jbdl95rest.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Repository
public class UserService {

    @Autowired
    UserRepository userRepository;

//    @Autowired
    ObjectMapper objectMapper;

    public UserService() {
//        this.userRepository = new UserRepository();
        this.objectMapper = new ObjectMapper();
    }

    public UserCreateResponse createUser(CreateUserRequest createUserRequest) {
//        UserRepository userRepository = new UserRepository();
        User user = createUserRequest.DtoToModel();
        user = userRepository.createUser(user);

        return UserCreateResponse.ModelToDto(user);
    }

    public GetUserResponse getUser(Integer id) {

//        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUser(id);
        return GetUserResponse.toModel(user);
    }

    public User merge(User incomingUser, User existingUser){

        HashMap<String,Object> incoming = this.objectMapper.convertValue(incomingUser,HashMap.class);
        HashMap<String,Object> existing = this.objectMapper.convertValue(existingUser,HashMap.class);

        for(String key : incoming.keySet()){
            if(incoming.get(key)!=null){
                existing.put(key,incoming.get(key));
            }
        }

        User mergedUser = this.objectMapper.convertValue(existing,User.class);
        return mergedUser;

    }

    public User patch2(Integer id, User incomingUser) {

        User existingUser = this.userRepository.getUser(id);

        if(existingUser==null)return null;

        User mergedUser = this.merge(incomingUser,existingUser);

         return this.userRepository.update(mergedUser);

    }

    public User patchUser(Integer id, User incomingUser) {

        User existingUser = this.userRepository.getUser(id);

        if(existingUser==null)return null;

        if(incomingUser.getName()!=null){
            existingUser.setName(incomingUser.getName());
        }
        if(incomingUser.getAge()!=null){
            existingUser.setAge(incomingUser.getAge());
        }
        if(incomingUser.getEmail()!=null){
            existingUser.setEmail(incomingUser.getEmail());
        }
        if(incomingUser.getGender()!=null){
            existingUser.setGender(incomingUser.getGender());
        }
        existingUser.setUpdatedOn(incomingUser.getUpdatedOn());

        return existingUser;

//        return GetUserResponse.toModel(existingUser);
    }

    public User putUser(Integer id, User model) {

        User existingUser = this.userRepository.getUser(id);
        if(existingUser==null)return null;

        return this.userRepository.update(model);
    }

    public User delete(Integer id) {
        User existingUser = this.userRepository.getUser(id);
        if(existingUser==null)
            throw new UserNotFoundException("user with id " + id + " not found");
        existingUser.setStatus(Status.INACTIVE);
        return this.userRepository.delete(id,existingUser);

    }
}
