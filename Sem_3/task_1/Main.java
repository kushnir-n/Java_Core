package Sem_3.task_1;
import java.time.LocalDate;
import java.util.List;
import Sem_3.task_1.classes.Assigment;
import Sem_3.task_1.classes.Boss;
import Sem_3.task_1.classes.Department;
import Sem_3.task_1.classes.Employee;
import Sem_3.task_1.classes.EmployeeService;
import Sem_3.task_1.classes.Task;
import Sem_3.task_1.classes.TaskPlanner;
import Sem_3.task_1.enums.Priority;
import Sem_3.task_1.enums.Skill;
import Sem_3.task_1.repository.EmployeeRepository;

public class Main {
    public static void main(String[] args) {
        //создание сотрудников
        Department department = new Department("Департамент 1");
        
        Employee employee1 = new Employee("Иванов", "Иван", LocalDate.of(1991, 03, 28), 111, department, Skill.HR);
        EmployeeRepository.addEmployee(employee1);
        Employee employee2 = new Employee("Иванова", "Ирина", LocalDate.of(1995, 04, 15), 130, department, Skill.ENGINEER);
        EmployeeRepository.addEmployee(employee2);
        Employee employee3 = new Employee("Шишмаков", "Денис", LocalDate.of(1997, 02, 03), 109, department, Skill.ENGINEER);
        EmployeeRepository.addEmployee(employee3);
        Employee kit = new Employee("Кушнир", "Прохор", LocalDate.of(1988, 10, 07), 5000, department, Skill.MANAGER);
        EmployeeRepository.addEmployee(kit);
        Employee employee4 = new Boss("Крыскин", "Олег", LocalDate.of(1990, 02, 04), 200, department, Skill.ENGINEER);
        EmployeeRepository.addEmployee(employee4);

        List<Employee> employees = EmployeeRepository.getEmployees();

        //создание задач
        Task task1 = new Task("Задача 1", 1, LocalDate.of(2023, 10, 17), Skill.ENGINEER, Priority.P1, 10);
        Task task2 = new Task("Задача 2", 2, LocalDate.of(2023, 10, 17), Skill.HR, Priority.P2, 15);

        Task task1t = new Task("Задача 1t", 1, LocalDate.of(2023, 10, 17), Skill.MANAGER, Priority.P1, 15);
        Task task2t = new Task("Задача 2t", 2, LocalDate.of(2023, 10, 17), Skill.MANAGER, Priority.P1, 15);
        Task task3t = new Task("Задача 3t", 1, LocalDate.of(2023, 10, 17), Skill.MANAGER, Priority.P2, 15);
        Task task4t = new Task("Задача 4t", 2, LocalDate.of(2023, 10, 17), Skill.MANAGER, Priority.P2, 15);
        Task task5t = new Task("Задача 5t", 1, LocalDate.of(2023, 10, 17), Skill.MANAGER, Priority.P3, 15);

        //назначение задач
        // TaskPlanner.setEmployees(employees);
        // Assigment assigment1 = TaskPlanner.planTask(task1);
        // Assigment assigment2 = TaskPlanner.planTask(task2);
        // //System.out.println(AssigmentRepository.getAssigmentList());
        // EmployeeService employeeService = new EmployeeService();
        // employeeService.startTaskByEmployee(assigment1.getEmployee(), assigment1);
        // employeeService.startTaskByEmployee(assigment1.getEmployee(), assigment2);

        TaskPlanner.setEmployees(employees);
        EmployeeService employeeService = new EmployeeService();
        
        Assigment assigment3 = TaskPlanner.planTask(task3t);
        Assigment assigment2 = TaskPlanner.planTask(task2t);
        Assigment assigment5 = TaskPlanner.planTask(task5t);
        Assigment assigment1 = TaskPlanner.planTask(task1t);        
        Assigment assigment4 = TaskPlanner.planTask(task4t);

        // employeeService.startTaskByEmployee(assigment1.getEmployee(), assigment1);
        // employeeService.startTaskByEmployee(assigment2.getEmployee(), assigment2);
        // employeeService.startTaskByEmployee(assigment3.getEmployee(), assigment3);
        // employeeService.startTaskByEmployee(assigment4.getEmployee(), assigment4);
        // employeeService.startTaskByEmployee(assigment5.getEmployee(), assigment5);
        
        // assigment = TaskPlanner.planTask(task3t);
        // employeeService.startTaskByEmployee(assigment.getEmployee(), assigment);
        // assigment = TaskPlanner.planTask(task4t);
        // employeeService.startTaskByEmployee(assigment.getEmployee(), assigment);
        // assigment = TaskPlanner.planTask(task5t);
        // employeeService.startTaskByEmployee(assigment.getEmployee(), assigment);

        // System.out.println(employeeService.getAssigmentsByEmployee(employee3));
        // System.out.println(employeeService.getAssigmentsByEmployee(employee1));
        // System.out.println(employee4);

        System.out.println("Зарплата до повышения:");
        for (Employee emp : employees){
            System.out.println(emp.getSalary());
        }

         // Повышение зарплаты всем сотрудникам, кроме руководителей
        Boss.increaseSalary(employees, 10);
        System.out.println("\nЗарплата после повышения:");
        for (Employee employee : employees) {
             System.out.println(employee.getSalary());
        }

        List<Assigment> kitAssigments = employeeService.getAssigmentsByEmployee(kit);

        System.out.println("-------до сортировки--------");
        for (Assigment assigment : kitAssigments){
            System.out.println(assigment.getTask().getName() + " rank: " + assigment.getTask().getRank() + " Priority: " + assigment.getTask().getPriority() + " Status: " + assigment.getStatus());
        }

        System.out.println("-------после сортировки-----");
        List<Assigment> sortKitAssigments = kitAssigments.stream().sorted().toList();
        for (Assigment assigment : sortKitAssigments){
            System.out.println(assigment.getTask().getName() + " rank: " + assigment.getTask().getRank() + " Priority: " + assigment.getTask().getPriority() + " Status: " + assigment.getStatus());
        }        
    }
}