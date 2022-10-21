package com.nadinsoft.notif.customer;

import com.nadinsoft.notif.alarm.AlarmEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class CustoomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nickname;

    private MembeerOf groop;

    @ManyToMany
    @JoinTable(
            name = "custoomer_alarm",
            joinColumns = {
                    @JoinColumn(name = "custoomer_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "alaarm_id")})
    Set<AlarmEntity> alaarmEntitySet = new HashSet<>();

    public CustoomerEntity(String username, MembeerOf groop) {
        this.nickname = username;
        this.groop = groop;
    }
}
