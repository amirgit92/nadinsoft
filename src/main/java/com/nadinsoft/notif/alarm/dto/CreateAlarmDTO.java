package com.nadinsoft.notif.alarm.dto;

import com.nadinsoft.notif.alarm.AlarmType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateAlarmDTO {
    private AlarmType type;

    private String alarmName;

    private String alarmMessage;

    public CreateAlarmDTO(AlarmType type,String name, String message){
        this.type = type;
        this.alarmName = name;
        this.alarmMessage = message;
    }
}

