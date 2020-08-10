package com.lti.mod.services.notificationservice.controller;

import com.lti.mod.services.notificationservice.dto.NotificationDTO;
import com.lti.mod.services.notificationservice.model.NotificationDO;
import com.lti.mod.services.notificationservice.service.NotificationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(value = "/notification/save", method = RequestMethod.POST)
    public ResponseEntity<?> createNotication(@RequestBody NotificationDTO notificationDto) throws Exception {
        System.out.println(" ########## NotificationController createNotication  ##########");
        return ResponseEntity.ok(notificationService.createNotification(notificationDto));
    }

    @RequestMapping(value = "/notification/get", method = RequestMethod.GET)
    public ResponseEntity<List<NotificationDO>> getNotificationByUserId(@RequestParam String userId) throws Exception {
        System.out.println(" ########## NotificationController getNotificationByUserId  ##########");
        List<NotificationDO> notificationDO = notificationService.getNotificationByUserId(Integer.parseInt(userId));
        return ResponseEntity.ok(notificationDO);
    }
}
