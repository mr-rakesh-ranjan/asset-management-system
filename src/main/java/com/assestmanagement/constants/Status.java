package com.assestmanagement.constants;

public enum Status {
    AVAILABLE("Available"), ASSIGNED("Assigned"), RCOVERED("Recovered");
    String status;

    Status(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
