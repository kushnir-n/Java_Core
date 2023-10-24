package Sem_3.task_1.classes;
import java.time.LocalDate;
import Sem_3.task_1.enums.Status;

public class Assigment implements Comparable<Assigment> {
    private Employee employee;
    private Task task;
    private LocalDate factStartDate;
    private LocalDate factEndDate;
    private Status status;
    private final int id;
    private static int count;

    public Assigment(Employee employee, Task task) {
        this.employee = employee;
        this.task = task;
        this.status = Status.NEW;
        this.id = count++;
    }

    public Assigment(Employee employee, Task task, Status status, int id) {
        this.employee = employee;
        this.task = task;
        this.status = status;
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Task getTask() {
        return task;
    }

    public LocalDate getFactStartDate() {
        return factStartDate;
    }

    public void setFactStartDate(LocalDate factStartDate) {
        this.factStartDate = factStartDate;
    }

    public LocalDate getFactEndDate() {
        return factEndDate;
    }

    public void setFactEndDate(LocalDate factEndDate) {
        this.factEndDate = factEndDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Assigment{" +
                "id = " + id +
                ", employee=" + employee + "\n" +
                ", task=" + task + "\n" +
                // ", factStartDate=" + factStartDate +
                // ", factEndDate=" + factEndDate +
                ", status=" + status +
                '}';
    }

    @Override
    public int compareTo(Assigment assigment) {
        int result = this.task.getPriority().compareTo(assigment.task.getPriority());
        if (result == 0) {
            result = assigment.task.getRank() - this.task.getRank();
        }
        return result;
    }
}