package com.assestmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;
    private String employeeName;
    private String employeeDesignation;

    public Employee(long employeeId, String employeeName, String employeeDesignation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDesignation = employeeDesignation;
    }

    public Employee() {
        super();
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Asset{");
        sb.append("employeeId=").append(employeeId);
        sb.append(", employeeName='").append(employeeName).append('\'');
        sb.append(", employeeDesignation='").append(employeeDesignation).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
