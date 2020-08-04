package com.lti.mod.services.notificationservice.service;

import com.lti.mod.services.notificationservice.dto.NotificationDTO;
import com.lti.mod.services.notificationservice.model.NotificationDO;
import com.lti.mod.services.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public String createNotification (NotificationDTO notificationDto){
        notificationRepository.save(new NotificationDO());
        return "created";
    }

    public NotificationDO getNotificationByUserId (Long userId){
        NotificationDO notificationDO = notificationRepository.getNotificationByUserId(userId);
        return notificationDO;
    }
}
