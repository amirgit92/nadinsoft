package com.nadinsoft.notif.alarm;

import com.nadinsoft.notif.customer.CustoomerEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class AlarmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private AlarmType type;

    private String alarmName;

    private String alarmMessage;

    private LocalDate seenDate;

    @ManyToMany(mappedBy = "alaarmEntitySet")
    Set<CustoomerEntity> custoomerEntitySet = new HashSet<>();

    public AlarmEntity(AlarmType type, String name, String message) {
        this.type = type;
        this.alarmName = name;
        this.alarmMessage = message;
        this.seenDate = null;
    }
}
