package com.nadinsoft.notif.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public CustoomerEntity findByUsername(String username) {
        return customerDao.findByNickname(username);
    }

    @Override
    public CustoomerEntity newCustomer(CustoomerEntity customer) {
        return customerDao.save(customer);
    }
}
