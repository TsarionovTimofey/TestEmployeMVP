package com.example.testemploye.screens.employee;

import com.example.testemploye.pojo.Employee;

import java.util.List;

public interface EmployeesListView {
    void showData(List<Employee> employees);

    void showError(Throwable throwable);
}
