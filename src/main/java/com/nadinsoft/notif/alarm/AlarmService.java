package com.nadinsoft.notif.alarm;

import com.nadinsoft.notif.alarm.dto.AlarmDTO;
import com.nadinsoft.notif.alarm.dto.CreateAlarmDTO;
import com.nadinsoft.notif.customer.CustoomerEntity;

import java.util.List;
import java.util.Set;

public interface AlarmService {

    AlarmEntity createNewAlarm(CreateAlarmDTO alarmDTO);

    void deleteAlarm(AlarmDTO alarmDTO);

    List<AlarmEntity> getProfileAlarms(Set<AlarmEntity> alarmEntitySet);

    AlarmEntity getAlarmByTypeAndName(AlarmDTO alarmDTO);
//    public List<AlarmEntity> getAlarmsByGroup(Group group);
}
