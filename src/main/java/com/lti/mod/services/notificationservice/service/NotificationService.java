package com.lti.mod.services.notificationservice.service;

import com.lti.mod.services.notificationservice.model.NotificationDO;
import com.lti.mod.services.notificationservice.repository.NotificationRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public NotificationDO createNotification(NotificationDO notificationDto) {
        return notificationRepository.save(notificationDto);
    }

    public List<NotificationDO> getNotificationByUserId (Long userId){
    	List<NotificationDO> notificationDO = notificationRepository.getNotificationByUserId(userId);
        return notificationDO;
    }

    public void closeNotification(Long userId) {
       notificationRepository.updateNotify(userId);
    }

}
