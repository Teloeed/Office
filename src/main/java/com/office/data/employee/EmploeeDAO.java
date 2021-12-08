package com.office.data.employee;

import com.office.data.employee.payment_type.Payment_type;
import com.office.db.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmploeeDAO {
    private List<Employee> empList;


    public List<Employee> findAll() {
        Connection connection = ConnectionManager.getInstance().getConnection();
        List<Employee> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select * from employy");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("fastName");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                Payment_type payment_type = payment_type(resultSet.getString("payment_type"));
                Role role = role(resultSet.getString("role"));
                Preference preference = preference(resultSet.getString("preference"));
                Preference currentPreference = preference(resultSet.getString("currentPreference"));

                Employee employee = new Employee(id, firstName, lastName, age, payment_type, role, preference, currentPreference);
                result.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Payment_type payment_type(String line) {
        String lineTemp = line.toLowerCase(Locale.ROOT);
        if (lineTemp.equals(Payment_type.Base.toString().toLowerCase(Locale.ROOT))) return Payment_type.Base;
        else if (lineTemp.equals(Payment_type.Combo.toString().toLowerCase(Locale.ROOT))) return Payment_type.Combo;
        else if (lineTemp.equals(Payment_type.PerHour.toString().toLowerCase(Locale.ROOT))) return Payment_type.PerHour;
        else return null;
    }
    private Role role(String line) {
        String lineTemp = line.toLowerCase(Locale.ROOT);
        if (lineTemp.equals(Role.Accountant.toString().toLowerCase(Locale.ROOT))) return Role.Accountant;
        else if (lineTemp.equals(Role.Programmer.toString().toLowerCase(Locale.ROOT))) return Role.Programmer;
        else if (lineTemp.equals(Role.Director.toString().toLowerCase(Locale.ROOT))) return Role.Director;
        else if (lineTemp.equals(Role.Driver.toString().toLowerCase(Locale.ROOT))) return Role.Driver;
        else return null;
    }
    private Preference preference(String line) {
        String lineTemp = line.toLowerCase(Locale.ROOT);
        if (lineTemp.equals(Preference.StartAndEnd_Earlier.toString().toLowerCase(Locale.ROOT))) return Preference.StartAndEnd_Earlier;
        else if (lineTemp.equals(Preference.StartAndEnd_Later.toString().toLowerCase(Locale.ROOT))) return Preference.StartAndEnd_Later;
        else if (lineTemp.equals(Preference.WorkFromHome.toString().toLowerCase(Locale.ROOT))) return Preference.WorkFromHome;
        else if (lineTemp.equals(Preference.Regular.toString().toLowerCase(Locale.ROOT))) return Preference.Regular;
        else return null;
    }
}
