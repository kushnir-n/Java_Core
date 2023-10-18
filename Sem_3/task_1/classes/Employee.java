package Sem_3.task_1.classes;
import java.time.LocalDate;
import Sem_3.task_1.enums.Skill;

public class Employee {
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private double salary;
    private Department department;
    private Skill skill;
    private boolean working = false;
    
    public Employee(String lastName, String firstName, LocalDate birthDate, double salary, Department department,
            Skill skill) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.salary = salary;
        this.department = department;
        this.skill = skill;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public Skill getSkill() {
        return skill;
    }

    public boolean getIsWorking() {
        return working;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
    
    public void setWorking(boolean working) {
        this.working = working;
    }

    @Override
    public String toString() {
        return "Employee [lastName=" + lastName + ", firstName=" + firstName + ", birthDate=" + birthDate + ", salary="
                + salary + ", department=" + department + ", skill=" + skill + ", working=" + working + "]";
    }

    public void increaseSalary(double amount) {
        salary += amount;
    }

}
