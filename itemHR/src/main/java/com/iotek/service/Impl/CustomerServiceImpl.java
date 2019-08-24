package com.iotek.service.Impl;

import com.iotek.dao.CustomerDao;
import com.iotek.model.Customer;
import com.iotek.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;
    public boolean checkName(String name) {
        Customer customer=new Customer(  );
        customer.setC_account( name );
        List<Customer> customers = customerDao.queryCustomer( customer );
        if(customers==null||customers.size()==0){
            return true;//没有重复的名字
        }else{
            return false;//有重复的名字
        }
    }

    public Customer login(Customer customer) {
        List<Customer> customers = customerDao.queryCustomer( customer );
        if(customers!=null&&customers.size()!=0){
            return customers.get( 0 );
        }else{
            return null;
        }

    }

    public void register(Customer customer) {
        boolean b = checkName( customer.getC_account() );
        if(b){
            customerDao.addCustomer( customer );
        }
    }
}
