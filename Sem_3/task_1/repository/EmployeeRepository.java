package Sem_3.task_1.repository;
import java.util.ArrayList;
import java.util.List;

import Sem_3.task_1.classes.Employee;

abstract public class EmployeeRepository {

    static private List<Employee> employees;

    static public List<Employee> addEmployee(Employee employee) {
        if (employees == null) employees = new ArrayList<>();
        employees.add(employee);
        return employees;
    }

    static public List<Employee> getEmployees() {
        return employees;
    }
    
}
