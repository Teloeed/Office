package com.office.data.employee;

import com.office.data.employee.payment_type.Payment_type;

public class Employee {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private Payment_type payment_type;
    private Role role;
    private final Preference preference;
    private Preference currentPreference;


    public Employee(int id, String firstName, String lastName, int age, Payment_type payment_type, Role role, Preference preference, Preference currentPreference) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.payment_type = payment_type;
        this.role = role;
        this.preference = preference;
        this.currentPreference = currentPreference;
    }

    public int getId() {
        return id;
    }
    public void setPayment_type(Payment_type payment_type) {
        this.payment_type = payment_type;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public void setCurrentPreference(Preference currentPreference) {
        this.currentPreference = currentPreference;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public Payment_type getPayment_type() {
        return payment_type;
    }
    public Role getRole() {
        return role;
    }
    public Preference getPreference() {
        return preference;
    }
    public Preference getCurrentPreference() {
        return currentPreference;
    }
}
