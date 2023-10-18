package Sem_3.task_1.classes;
import java.time.LocalDate;
import java.util.List;

import Sem_3.task_1.enums.Skill;

public class Boss extends Employee {

    public Boss(String lastName, String firstName, LocalDate birthDate, double salary, Department department, Skill skill) {
        super(lastName, firstName, birthDate, salary, department, skill);
    }

    public static void increaseSalary(List<Employee> employees, double amount) {
        for (Employee employee : employees) {
            if (!(employee instanceof Boss)) {
                employee.increaseSalary(amount);
            }
        }    
    }
}