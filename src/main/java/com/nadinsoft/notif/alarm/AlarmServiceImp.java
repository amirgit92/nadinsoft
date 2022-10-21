package com.nadinsoft.notif.alarm;

import com.nadinsoft.notif.alarm.dto.AlarmDTO;
import com.nadinsoft.notif.alarm.dto.CreateAlarmDTO;
import com.nadinsoft.notif.customer.CustoomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class AlarmServiceImp implements AlarmService {

    @Autowired
    AlarmDao alarmDao;

    @Override
    public AlarmEntity createNewAlarm(CreateAlarmDTO createAlarmDTO) {
        AlarmEntity alarm = new AlarmEntity();
        alarm = createAlarmDtoToAlarmEntity(createAlarmDTO);
        return alarmDao.save(createAlarmDtoToAlarmEntity(createAlarmDTO));
    }

    @Override
    public void deleteAlarm(AlarmDTO alarmDTO) {
        AlarmEntity alarm = AlarmDtoToAlarmEntity(alarmDTO);
        alarmDao.deleteByTypeAndAlarmName(alarm.getType(), alarm.getAlarmName());
    }

    @Override
    public List<AlarmEntity> getProfileAlarms(Set<AlarmEntity> alarmEntitySet) {
        return alarmDao.findAllByCustoomerEntitySetIn(alarmEntitySet);
    }

    @Override
    public AlarmEntity getAlarmByTypeAndName(AlarmDTO alarmDTO) {
        AlarmEntity alarm = new AlarmEntity();
        alarm = AlarmDtoToAlarmEntity(alarmDTO);
        alarm.setSeenDate(LocalDate.now());
        alarmDao.save(alarm);
        return alarmDao.getAlarmEntityByTypeAndAlarmName(alarm.getType(), alarm.getAlarmName());
    }

    private AlarmEntity AlarmDtoToAlarmEntity(AlarmDTO alarmDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(alarmDTO, AlarmEntity.class);
    }

    private AlarmEntity createAlarmDtoToAlarmEntity(CreateAlarmDTO alarmDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(alarmDTO, AlarmEntity.class);
    }
}
