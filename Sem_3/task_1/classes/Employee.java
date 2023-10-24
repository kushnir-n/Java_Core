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
    private final int id;
    private static int count;
    
    public Employee(String lastName, String firstName, LocalDate birthDate, double salary, Department department, Skill skill) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.salary = salary;
        this.department = department;
        this.skill = skill;
        this.id = count++;
    }

    public Employee(String lastName, String firstName, LocalDate birthDate, double salary, Skill skill, int id) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.salary = salary;
        this.skill = skill;
        this.id = id;
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id= " + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", salary=" + salary +
                ", skill=" + skill +
                '}';
    }

    public void increaseSalary(double amount) {
        salary += amount;
    }

}
