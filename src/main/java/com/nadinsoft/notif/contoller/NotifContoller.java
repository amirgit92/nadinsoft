package com.nadinsoft.notif.contoller;

import com.nadinsoft.notif.alarm.AlarmEntity;
import com.nadinsoft.notif.alarm.dto.AlarmDTO;
import com.nadinsoft.notif.alarm.dto.CreateAlarmDTO;

import java.util.List;

public interface NotifContoller {
    AlarmEntity showAlarm(AlarmDTO alarmDTO);

    List<AlarmEntity> showProfileAlarms(String username);

    AlarmEntity createNewAlarm(CreateAlarmDTO createAlarmDTO);
}
