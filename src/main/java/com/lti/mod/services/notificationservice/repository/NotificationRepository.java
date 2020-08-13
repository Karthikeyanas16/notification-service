package com.lti.mod.services.notificationservice.repository;

import com.lti.mod.services.notificationservice.model.NotificationDO;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface NotificationRepository extends CrudRepository<NotificationDO,Integer> {

    @Query("SELECT u FROM NotificationDO u WHERE u.user_id = ?1 and u.status ='0' ORDER BY u.id DESC")
    public List<NotificationDO> getNotificationByUserId(Long userId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE notification set notification.status ='1' where notification.user_id = ?1",
            nativeQuery = true)
    void updateNotify(Long userId);
}
