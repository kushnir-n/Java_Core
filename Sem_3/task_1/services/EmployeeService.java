package Sem_3.task_1.services;
import java.time.LocalDate;
import java.util.List;
import Sem_3.task_1.classes.Assigment;
import Sem_3.task_1.classes.Employee;
import Sem_3.task_1.enums.Status;
import Sem_3.task_1.repository.AssigmentRepository;

public class EmployeeService {
    public List<Assigment> getAssigmentsByEmployee(Employee employee) {
        return AssigmentRepository.getAssigmentList().stream().filter(x -> x.getEmployee() == employee).toList();
    }

    public void startTaskByEmployee(Employee employee, Assigment assigment) {
        employee.setWorking(true);
        assigment.setFactStartDate(LocalDate.now());
        assigment.setStatus(Status.IN_PROGRESS);
    }

    public void finishTaskByEmployee(Employee employee, Assigment assigment) {
        employee.setWorking(false);
        assigment.setFactStartDate(LocalDate.now());
        assigment.setStatus(Status.COMPLETED);
    }
}