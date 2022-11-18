package com.assestmanagement.service.impl;

import com.assestmanagement.dao.EmployeeDao;
import com.assestmanagement.entity.Employee;
import com.assestmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee addEmployee(Employee emp) {
        this.employeeDao.save(emp);
        return emp;
    }
}
