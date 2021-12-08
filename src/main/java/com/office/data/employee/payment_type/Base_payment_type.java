package com.office.data.employee.payment_type;

public class Base_payment_type  {
    private final int workHours = 160;
    private final int salaryPerHour = 15;


    public int getSalaryAmount() {
        return workHours*salaryPerHour;
    }
}
