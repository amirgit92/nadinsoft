package com.nadinsoft.notif.alarm.dto;

import com.nadinsoft.notif.alarm.AlarmType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AlarmDTO {

    private AlarmType type;

    private String alarmName;
}
