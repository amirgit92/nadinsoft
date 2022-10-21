package com.nadinsoft.notif.customer;

public interface CustomerService {

    CustoomerEntity findByUsername(String username);

    CustoomerEntity newCustomer(CustoomerEntity customer);
}
