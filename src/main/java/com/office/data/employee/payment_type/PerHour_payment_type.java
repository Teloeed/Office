package com.office.data.employee.payment_type;

public class PerHour_payment_type {
    private int workHours;
    private final int salaryPerHour = 25;
    private final int baseHours = 100;

    public int getSalaryAmount(){
        workHours = (int)(Math.random() * 100) + baseHours;
        return workHours*salaryPerHour;
    }
}
