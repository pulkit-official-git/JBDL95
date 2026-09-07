package com.springcoreconecpts.notifsvc95;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notif")
public class NotificationController {

    Logger logger = LoggerFactory.getLogger(NotificationController.class);


    @GetMapping("/get")
    public void get() {

        logger.info("inside notifff svc");
    }
}
