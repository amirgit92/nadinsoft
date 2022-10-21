package com.nadinsoft.notif.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<CustoomerEntity, Long> {
    //    List<AlarmEntity> findAllByGroup(MemberOf group);

    CustoomerEntity findByNickname(String username);
}
