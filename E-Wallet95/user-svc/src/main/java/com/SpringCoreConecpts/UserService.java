package com.SpringCoreConecpts;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public void create(User user) {

        this.userRepository.save(user);

        JSONObject jsonObject = this.objectMapper.convertValue(user, JSONObject.class);
        this.kafkaTemplate.send("user-created95",jsonObject.toString());
    }
}
