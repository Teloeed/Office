package com.office.data.employee.payment_type;

public class Combo_payment_type  {
    private final int workHours = 160;
    private final int salaryPerHour = 15;
    private int totalSale;
    private int percent = 2;


    public int getSalaryAmount() {
        totalSale = (int)(Math.random() * 300000);
        return workHours*salaryPerHour + totalSale*(percent/100);
    }
}
