package Sem_3.task_1.services;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Sem_3.task_1.classes.Assigment;
import Sem_3.task_1.classes.Employee;
import Sem_3.task_1.classes.Task;
import Sem_3.task_1.enums.Priority;
import Sem_3.task_1.enums.Skill;
import Sem_3.task_1.enums.Status;

public class FileService {
    
    public void fileWriter(List<String> dats, String fileName, boolean append) {
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String s : dats) {
                fileWriter.write(s.toString() + "\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String writeEmployee(Employee employee){
        return String.format("%s;%s;%s;%.1f;%s;%d;", 
            employee.getLastName(), employee.getFirstName(), employee.getBirthDate(), employee.getSalary(), employee.getSkill(), employee.getId());
    }

    public void fileWriterEmployee(List<Employee> employees) {
        String fileName = "employees.txt";
        List<String> employeesList = new ArrayList<>();
        String emplStr = "";
        for (Employee empl : employees) {
            emplStr = writeEmployee(empl);
            employeesList.add(emplStr);
        }
        fileWriter(employeesList, fileName, false);
    }    

    private String writeTask(Task task){
        return String.format("%s;%d;%s;%s;%s;%s;%d;%d;", 
            task.getName(), task.getRank(), task.getCreateDate(), task.getDueDate(), task.getSkill(), task.getPriority(), task.getLength(), task.getId());
    }

    public void fileWriterTask(List<Task> tasks) {
        String fileName = "tasks.txt";
        List<String> tasksList = new ArrayList<>();
        String taskStr = "";
        for (Task task : tasks) {
            taskStr = writeTask(task);
            tasksList.add(taskStr);
        }
        fileWriter(tasksList, fileName, false);
    }

    private String writeAssignment(Assigment assigment){
        return String.format("%s|%s|%s;%d;|", 
            writeEmployee(assigment.getEmployee()), writeTask(assigment.getTask()), assigment.getStatus(), assigment.getId());
    }

    public void fileWriterAssigment(List<Assigment> assigments) {
        String fileName = "assigments.txt";
        List<String> assigmentsList = new ArrayList<>();
        String assigmentStr = "";
        for (Assigment assigment : assigments) {
            assigmentStr = writeAssignment(assigment);
            assigmentsList.add(assigmentStr);
        }
        fileWriter(assigmentsList, fileName, false);
    }

    public List<String> fileReader(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Employee readEmployee(String[] employeeString){
        String lastName = employeeString[0];
        String firstName = employeeString[1];
        String[] tempLocalDate = employeeString[2].split("-");
        LocalDate birthDay = LocalDate.of(Integer.parseInt(tempLocalDate[0]), Integer.parseInt(tempLocalDate[1]), Integer.parseInt(tempLocalDate[2]));
        double salary = Double.parseDouble(employeeString[3].replace(',', '.'));
        Skill skill = Skill.ENGINEER;
        if (employeeString[4].equals(Skill.HR.toString()))
            skill = Skill.HR;
        if (employeeString[4].equals(Skill.MANAGER.toString()))
            skill = Skill.MANAGER;
        if (employeeString[4].equals(Skill.ENGINEER.toString()))
            skill = Skill.ENGINEER;
        if (employeeString[4].equals(Skill.QA.toString()))
            skill = Skill.QA;
        int id = Integer.parseInt(employeeString[5]);
        return new Employee(lastName, firstName, birthDay, salary, skill, id);
    }

    public List<Employee> fileReaderEmployee() {
        List<Employee> employees = new ArrayList<>();
        List<String> tempEmployee = fileReader("employees.txt");
        String[] temp;
        for (String str : tempEmployee) {
            temp = str.split(";");            
            Employee employee = readEmployee(temp);
            employees.add(employee);
        }
        return employees;
    }

    private Task readTask(String[] taskString){
        String name = taskString[0];
        int rank = Integer.parseInt(taskString[1]);
        String[] tempCreateDate = taskString[2].split("-");
        LocalDate createDate = LocalDate.of(Integer.parseInt(tempCreateDate[0]), Integer.parseInt(tempCreateDate[1]), Integer.parseInt(tempCreateDate[2]));
        String[] tempDueDate = taskString[3].split("-");
        LocalDate dueDate = LocalDate.of(Integer.parseInt(tempDueDate[0]), Integer.parseInt(tempDueDate[1]), Integer.parseInt(tempDueDate[2]));
        Skill skill = null;
        if (taskString[4].equals(Skill.HR.toString()))
            skill = Skill.HR;
        if (taskString[4].equals(Skill.MANAGER.toString()))
            skill = Skill.MANAGER;
        if (taskString[4].equals(Skill.ENGINEER.toString()))
            skill = Skill.ENGINEER;
        if (taskString[4].equals(Skill.QA.toString()))
            skill = Skill.QA;
        Priority priority = null;
        if (taskString[5].equals(Priority.P1.toString()))
            priority = Priority.P1;
        if (taskString[5].equals(Priority.P2.toString()))
            priority = Priority.P2;
        if (taskString[5].equals(Priority.P3.toString()))
            priority = Priority.P3;
        int length = Integer.parseInt(taskString[6]);
        int id = Integer.parseInt(taskString[7]);
        return new Task(name, rank, createDate, dueDate, skill, priority, length, id);
    }

    public List<Task> fileReaderTask(){
        List<Task> tasks = new ArrayList<>();
        List<String> tempTask = fileReader("tasks.txt");
        String[] temp;
        for (String str : tempTask) {
            temp = str.split(";");                            
            Task task = readTask(temp);
            tasks.add(task);
        }
        return tasks;
    }

    private Assigment readAssigment(String[] assignmentString){
        Employee employee = readEmployee(assignmentString[0].split(";"));
        Task task = readTask(assignmentString[1].split(";"));
        Status status = null;
        if (assignmentString[2].split(";")[0].equals(Status.NEW.toString()))
            status = Status.NEW;
        if (assignmentString[2].split(";")[0].equals(Status.IN_PROGRESS.toString()))
            status = Status.IN_PROGRESS;
        if (assignmentString[2].split(";")[0].equals(Status.COMPLETED.toString()))
            status = Status.COMPLETED;
        if (assignmentString[2].split(";")[0].equals(Status.ON_HOLD.toString()))
            status = Status.ON_HOLD;
        int id = Integer.parseInt(assignmentString[2].split(";")[1]);
        return new Assigment(employee, task, status, id);
    }

    public List<Assigment> fileReaderAssigment() {
        List<Assigment> assigments = new ArrayList<>();
        List<String> tempAssigments = fileReader("assigments.txt");
        String[] temp;
        for (String str : tempAssigments) {
            temp = str.split("\\|");
            Assigment assigment = readAssigment(temp);
            assigments.add(assigment);
        }
        return assigments;
    }
}