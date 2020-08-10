package com.lti.mod.services.notificationservice.repository;

import com.lti.mod.services.notificationservice.model.NotificationDO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<NotificationDO,Integer> {

    @Query("SELECT u FROM NotificationDO u WHERE u.userId = ?1")
    public List<NotificationDO> getNotificationByUserId(Integer userId);
}
