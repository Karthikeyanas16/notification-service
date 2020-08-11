package com.lti.mod.services.notificationservice.service;

import com.lti.mod.services.notificationservice.dto.NotificationDTO;
import com.lti.mod.services.notificationservice.model.NotificationDO;
import com.lti.mod.services.notificationservice.repository.NotificationRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public String createNotification (NotificationDTO notificationDto){
        NotificationDO notificationDO = new NotificationDO();
        notificationDO.setCreatedOn(new java.sql.Date(notificationDto.getCreatedOn().getTime()));
        notificationDO.setDescription(notificationDto.getDescription());
        notificationDO.setUserId(notificationDto.getUserId());
        notificationDO.setModifiedOn(new java.sql.Date(notificationDto.getModifiedOn().getTime()));
        notificationDO.setStatus(notificationDto.getStatus());
        notificationRepository.save(notificationDO);
        return "created";
    }

    public List<NotificationDO> getNotificationByUserId (Long userId){
    	List<NotificationDO> notificationDO = notificationRepository.getNotificationByUserId(userId);
        return notificationDO;
    }
}
