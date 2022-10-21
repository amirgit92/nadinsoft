package com.nadinsoft.notif.alarm;

import com.nadinsoft.notif.customer.CustoomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AlarmDao extends JpaRepository<AlarmEntity, Long> {

    AlarmEntity getAlarmEntityByTypeAndAlarmName(AlarmType type, String name);

    void deleteByTypeAndAlarmName(AlarmType type, String name);

   List<AlarmEntity> findAllByCustoomerEntitySetIn(Set<AlarmEntity> alarmEntitySet);
}
