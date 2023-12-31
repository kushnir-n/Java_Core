package Sem_3.task_1;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import Sem_3.task_1.classes.Assigment;
import Sem_3.task_1.classes.Boss;
import Sem_3.task_1.classes.Department;
import Sem_3.task_1.classes.Employee;
import Sem_3.task_1.classes.Task;
import Sem_3.task_1.classes.TaskPlanner;
import Sem_3.task_1.enums.Priority;
import Sem_3.task_1.enums.Skill;
import Sem_3.task_1.repository.AssigmentRepository;
import Sem_3.task_1.repository.EmployeeRepository;
import Sem_3.task_1.repository.FreeTaskRepository;
import Sem_3.task_1.repository.TaskRepository;
import Sem_3.task_1.services.EmployeeService;
import Sem_3.task_1.services.FileService;

public class Main {
    public static void main(String[] args) {
        // создание сотрудников
        Department department = new Department("Департамент 1");

        Employee employee1 = new Employee("Иванов", "Иван", LocalDate.of(1991, 03, 28), 111, department, Skill.HR);
        EmployeeRepository.addEmployee(employee1);
        Employee employee2 = new Employee("Иванова", "Ирина", LocalDate.of(1995, 04, 15), 130, department,
                Skill.ENGINEER);
        EmployeeRepository.addEmployee(employee2);
        Employee employee3 = new Employee("Шишмаков", "Денис", LocalDate.of(1997, 02, 03), 109, department,
                Skill.ENGINEER);
        EmployeeRepository.addEmployee(employee3);
        Employee kit = new Employee("Кушнир", "Нат", LocalDate.of(1988, 10, 07), 5000, department, Skill.MANAGER);
        EmployeeRepository.addEmployee(kit);
        Boss employee4 = new Boss("Крыскин", "Олег", LocalDate.of(1990, 02, 04), 200, department, Skill.ENGINEER);
        EmployeeRepository.addEmployee(employee4);

        List<Employee> employees = EmployeeRepository.getEmployees();

        // создание задач
        Task task1 = new Task("Задача 1", 1, LocalDate.of(2023, 10, 17), Skill.MANAGER, Priority.P1, 10);
        TaskRepository.addTasks(task1);
        Task task2 = new Task("Задача 2", 2, LocalDate.of(2023, 10, 17), Skill.HR, Priority.P2, 15);
        TaskRepository.addTasks(task2);
        Task task3 = new Task("Задача 3", 1, LocalDate.of(2023, 10, 17), Skill.MANAGER, Priority.P1, 10);
        TaskRepository.addTasks(task3);
        Task task4 = new Task("Задача 4", 2, LocalDate.of(2023, 10, 17), Skill.HR, Priority.P2, 15);
        TaskRepository.addTasks(task4);
        Task task5 = new Task("Задача 5", 1, LocalDate.of(2023, 10, 17), Skill.MANAGER, Priority.P1, 10);
        TaskRepository.addTasks(task5);
        Task task6 = new Task("Задача 6", 2, LocalDate.of(2023, 10, 17), Skill.QA, Priority.P2, 15);
        TaskRepository.addTasks(task6);
        Task task7 = new Task("Задача 7", 1, LocalDate.of(2023, 10, 17), Skill.QA, Priority.P1, 10);
        TaskRepository.addTasks(task7);
        Task task8 = new Task("Задача 8", 2, LocalDate.of(2023, 10, 17), Skill.QA, Priority.P2, 15);
        TaskRepository.addTasks(task8);

        // Task task1t = new Task("Задача 1t", 1, LocalDate.of(2023, 10, 17),
        // Skill.MANAGER, Priority.P1, 15);
        // Task task2t = new Task("Задача 2t", 2, LocalDate.of(2023, 10, 17),
        // Skill.MANAGER, Priority.P1, 15);
        // Task task3t = new Task("Задача 3t", 1, LocalDate.of(2023, 10, 17),
        // Skill.MANAGER, Priority.P2, 15);
        // Task task4t = new Task("Задача 4t", 2, LocalDate.of(2023, 10, 17),
        // Skill.MANAGER, Priority.P2, 15);
        // Task task5t = new Task("Задача 5t", 1, LocalDate.of(2023, 10, 17),
        // Skill.MANAGER, Priority.P3, 15);

        // назначение нескольких задач на одного
        TaskPlanner.setEmployees(employees);

        Assigment assigment1 = TaskPlanner.planTask(task1);
        Assigment assigment3 = TaskPlanner.planTask(task3);
        Assigment assigment5 = TaskPlanner.planTask(task5);

        // задача без исполнителя
        Assigment assigment8 = TaskPlanner.planTask(task8);

        EmployeeService employeeService = new EmployeeService();

        // проверка на назначение
        if (AssigmentRepository.checkAssignment(assigment1)) {
            employeeService.startTaskByEmployee(assigment1.getEmployee(), assigment1);
        }
        if (AssigmentRepository.checkAssignment(assigment3)) {
            employeeService.startTaskByEmployee(assigment3.getEmployee(), assigment3);
        }
        if (AssigmentRepository.checkAssignment(assigment5)) {
            employeeService.startTaskByEmployee(assigment5.getEmployee(), assigment5);
        }
        if (AssigmentRepository.checkAssignment(assigment8)) {
            employeeService.startTaskByEmployee(assigment8.getEmployee(), assigment8);
        }

        // назначение таска боссом
        Assigment assigment6 = employee4.setAssignment(task2);
        Assigment assigment7 = employee4.setAssignment(task4);

        if (AssigmentRepository.checkAssignment(assigment6)) {
            employeeService.startTaskByEmployee(assigment6.getEmployee(), assigment6);
        }
        if (AssigmentRepository.checkAssignment(assigment7)) {
            employeeService.startTaskByEmployee(assigment7.getEmployee(), assigment7);
        }

        //System.out.println("Список задач без исполнителя: " + FreeTaskRepository.getfreeTasksList());
        //System.out.println("Список назначенных задач: " + AssigmentRepository.getAssigmentList());

        // TaskPlanner.setEmployees(employees);
        // EmployeeService employeeService = new EmployeeService();

        // Assigment assigment3 = TaskPlanner.planTask(task3t);
        // Assigment assigment2 = TaskPlanner.planTask(task2t);
        // Assigment assigment5 = TaskPlanner.planTask(task5t);
        // Assigment assigment1 = TaskPlanner.planTask(task1t);
        // Assigment assigment4 = TaskPlanner.planTask(task4t);

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

        // System.out.println("Зарплата до повышения:");
        // for (Employee emp : employees){
        // System.out.println(emp.getSalary());
        // }

        // // Повышение зарплаты всем сотрудникам, кроме руководителей
        // Boss.increaseSalary(employees, 10);
        // System.out.println("\nЗарплата после повышения:");
        // for (Employee employee : employees) {
        // System.out.println(employee.getSalary());
        // }

        // List<Assigment> kitAssigments = employeeService.getAssigmentsByEmployee(kit);

        // System.out.println("-------до сортировки--------");
        // for (Assigment assigment : kitAssigments){
        // System.out.println(assigment.getTask().getName() + " rank: " +
        // assigment.getTask().getRank() + " Priority: " +
        // assigment.getTask().getPriority() + " Status: " + assigment.getStatus());
        // }

        // System.out.println("-------после сортировки-----");
        // List<Assigment> sortKitAssigments = kitAssigments.stream().sorted().toList();
        // for (Assigment assigment : sortKitAssigments){
        // System.out.println(assigment.getTask().getName() + " rank: " +
        // assigment.getTask().getRank() + " Priority: " +
        // assigment.getTask().getPriority() + " Status: " + assigment.getStatus());
        // }

        // for (Assigment assigment : employeeService.getAssigmentsByEmployee(kit)){
        // System.out.println(assigment.getEmployee() + " - " + assigment);
        // }

        // for (Assigment assigment :
        // employeeService.getAssigmentsByEmployee(employee1)){
        // System.out.println(assigment.getEmployee() + " - " + assigment);
        // }

        FileService fileService = new FileService();

        //fileService.fileWriterEmployee(EmployeeRepository.getEmployees());
        //fileService.fileWriterTask(TaskRepository.getTasksList());
        //fileService.fileWriterAssigment(AssigmentRepository.getAssigmentList());

        //System.out.println("=====Читаем Employees из файла=====");
        //System.out.println(fileService.fileReaderEmployee());
        //System.out.println("=====Читаем Employees из файла - Завершено=====");
        //System.out.println("=====Читаем Tasks из файла=====");
        //System.out.println(fileService.fileReaderTask());
        //System.out.println("=====Читаем Tasks из файла - Завершено=====");
        //System.out.println("=====Читаем Assignments из файла=====");
        //System.out.println(fileService.fileReaderAssigment());
        //System.out.println("=====Читаем Assignments из файла - Завершено=====");

// меню команд
        System.out.println("1 - добавление Employee в файл и вывод в консоль\n2 - добавление Task в файл и вывод в консоль\n3 - добавление Assigments в файл и вывод в консоль\n4 - вывод списка задач без исполнителя\n5 - поиск задачи по Id сотрудника");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите нужную команду: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1: //добавление Employee в файл и вывод в консоль
                fileService.fileWriterEmployee(EmployeeRepository.getEmployees());
                System.out.println("=====Читаем Employees из файла=====");
                System.out.println(fileService.fileReaderEmployee());
                System.out.println("=====Читаем Employees из файла - Завершено=====");
                break;
            case 2: //добавление Task в файл и вывод в консоль
                fileService.fileWriterTask(TaskRepository.getTasksList());
                System.out.println("=====Читаем Tasks из файла=====");
                System.out.println(fileService.fileReaderTask());
                System.out.println("=====Читаем Tasks из файла - Завершено=====");
                break;
            case 3: ////добавление Assigments в файл и вывод в консоль
                fileService.fileWriterAssigment(AssigmentRepository.getAssigmentList());
                System.out.println("=====Читаем Assignments из файла=====");
                System.out.println(fileService.fileReaderAssigment());
                System.out.println("=====Читаем Assignments из файла - Завершено=====");
                break;
            case 4: // вывод списка задач без исполнителя
                System.out.println("Список задач без исполнителя: " + FreeTaskRepository.getfreeTasksList());
                break;
            case 5: // вывод задачи по Id сотрудника
                System.out.print("Введите Id сотрудника: ");
                int empId = scanner.nextInt();
                System.out.println("Задачи по Id сотрудника " + empId +":" + AssigmentRepository.getAssigmentList().stream().filter(x -> x.getEmployee().getId() == empId).toList());
        }
    }
}