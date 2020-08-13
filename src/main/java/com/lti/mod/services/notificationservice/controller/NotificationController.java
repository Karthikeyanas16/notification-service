package com.lti.mod.services.notificationservice.controller;

import com.lti.mod.services.notificationservice.dto.NotificationDTO;
import com.lti.mod.services.notificationservice.model.NotificationDO;
import com.lti.mod.services.notificationservice.repository.NotificationRepository;
import com.lti.mod.services.notificationservice.service.NotificationService;

import java.util.List;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/notification/save")
    public ResponseEntity<?> createNotification(@RequestBody NotificationDO notificationDto) throws NotFoundException {
        System.out.println(" ########## NotificationController createNotication  ##########");
        System.out.println(notificationDto.getUserId());
        System.out.println(notificationDto.getDescription());
        return new ResponseEntity<>(notificationService.createNotification(notificationDto), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/notification/close/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> closeNotification(@PathVariable Long id) throws NotFoundException {
        notificationService.closeNotification(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/notification/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<NotificationDO>> getNotificationByUserId(@PathVariable Long id) throws Exception {
        System.out.println(" ########## NotificationController getNotificationByUserId  ##########");
        List<NotificationDO> notificationDO = notificationService.getNotificationByUserId(id);
        return ResponseEntity.ok(notificationDO);
    }
}
