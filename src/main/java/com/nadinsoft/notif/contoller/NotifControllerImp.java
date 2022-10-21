package com.nadinsoft.notif.contoller;

import com.nadinsoft.notif.alarm.AlarmDao;
import com.nadinsoft.notif.alarm.AlarmEntity;
import com.nadinsoft.notif.alarm.AlarmService;
import com.nadinsoft.notif.alarm.dto.AlarmDTO;
import com.nadinsoft.notif.alarm.dto.CreateAlarmDTO;
import com.nadinsoft.notif.customer.CustomerService;
import com.nadinsoft.notif.customer.CustoomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotifControllerImp implements NotifContoller {
    @Autowired
    AlarmService alarmService;
    @Autowired
    CustomerService customerService;

    @Override
    @GetMapping("/show_alarm")
    //AlarmDTO contains: AlarmType type, String name.
    public AlarmEntity showAlarm(AlarmDTO alarmDTO) {
        return alarmService.getAlarmByTypeAndName(alarmDTO);
    }

    @Override
    @GetMapping("/profile_alarms")
    public List<AlarmEntity> showProfileAlarms(@RequestParam String username) {
        CustoomerEntity customer = customerService.findByUsername(username);
        customer.getAlaarmEntitySet();
        return alarmService.getProfileAlarms(customer.getAlaarmEntitySet());

    }

    @Override
    @PostMapping("/create_alarm")
    //CreateAlarmDTO contains : Alarmtype type, String name, String message.
    public AlarmEntity createNewAlarm(@RequestBody CreateAlarmDTO createAlarmDTO) {
        return alarmService.createNewAlarm(createAlarmDTO);
    }

    public void deleteAlarm(@RequestBody AlarmDTO alarmDTO){
        alarmService.deleteAlarm(alarmDTO);
    }
}
